import { init, WASI } from '@wasmer/wasi'

let module = undefined;

export async function computePrime(number) {
    if (module === undefined) {
        await init();
        module = await WebAssembly.compileStreaming(fetch('prime.wasm'));
    }

    let wasi = new WASI({
        env: {},
        args: [
            'prime.wasm', number
        ],
    });
    
    await wasi.instantiate(module, {});
    wasi.start();
    return wasi.getStdoutString();
}
