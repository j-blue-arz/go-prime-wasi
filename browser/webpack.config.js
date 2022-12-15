module.exports = {
  mode: "development",
  entry: "./src/prime.js",
  externals: {
    "wasmer_wasi_js_bg.wasm": true,
  },
};
