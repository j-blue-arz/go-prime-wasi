import { init, WASI } from '@wasmer/wasi'

export async function computePrime() {
    await init()

    let wasi = new WASI({
        env: {},
        args: [
            'prime.wasm', '854654651354613023354657879465120356462134'
        ],
    })

    const moduleBytes = fetch('prime.wasm')
    const module = await WebAssembly.compileStreaming(moduleBytes)
    // Instantiate the WASI module
    await wasi.instantiate(module, {})

    // Run the start function
    
    let exitCode = wasi.start();
    let stdout = wasi.getStdoutString()

    // This should print "hello world (exit code: 0)"
    console.log(`${stdout}(exit code: ${exitCode})`)
}
