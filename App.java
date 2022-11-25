import org.graalvm.polyglot.*;
import org.graalvm.polyglot.io.ByteSequence;

public class App {

  public static void main(String[] args) throws Exception {
    //Load the WASM contents into a byte array
    byte[] binary = readBytes("example.wasm");
    Context.Builder contextBuilder = Context.newBuilder("wasm");
    Source.Builder sourceBuilder = Source.newBuilder(
      "wasm",
      ByteSequence.create(binary),
      "example"
    );
    Source source = sourceBuilder.build();
    Context context = contextBuilder.build();

    context.eval(source);

    Value mainFunction = context
      .getBindings("wasm")
      .getMember("main")
      .getMember("_start");
    mainFunction.execute();
  }
}
