
import java.io.File;
import org.graalvm.polyglot.*;

public class Prime {

    public static void main(String[] args) throws Exception {
        File file = new File(Thread
                .currentThread()
                .getContextClassLoader()
                .getResource("prime.wasm")
                .getFile());
        Source.Builder sourceBuilder = Source.newBuilder("wasm", file);
        Source source = sourceBuilder.build();

        Context.Builder contextBuilder = Context.newBuilder("wasm")//
                .option("wasm.Builtins", "wasi_snapshot_preview1").//
                arguments("wasm", new String[]{"prime.wasm", args[0]});

        try (Context context = contextBuilder.build()) {
            context.eval(source);

            Value mainFunction = context
                    .getBindings("wasm")
                    .getMember("main")
                    .getMember("_start");
            mainFunction.execute();
        } 
    }
}
