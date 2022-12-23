
import java.io.IOException;
import java.util.Objects;
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.io.ByteSequence;

public class Prime {

    public static void main(String[] args) throws Exception {
        byte[] binary = loadWasm();
        Context.Builder contextBuilder = Context.newBuilder("wasm").option("wasm.Builtins", "wasi_snapshot_preview1").arguments("wasm", new String[]{"prime.wasm", "7"});
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
        try {
            mainFunction.execute();
        } catch (PolyglotException e) {
            if (!e.isExit()) {
                throw e;
            }
        }

    }

    private static byte[] loadWasm() throws IOException {
        try (
                 var doomWasm = Thread
                        .currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("prime.wasm")) {
                    return Objects.requireNonNull(doomWasm).readAllBytes();
                }
    }
}
