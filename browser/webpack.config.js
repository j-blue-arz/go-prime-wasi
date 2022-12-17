const CopyPlugin = require('copy-webpack-plugin')
const path = require('path')
const webpack = require('webpack')

module.exports = {
    mode: 'development',
    entry: './src/index.js',
    externals: {
        'wasmer_wasi_js_bg.wasm': true,
    },
    plugins: [
        new CopyPlugin({
            patterns: ['src/index.html', 'src/prime.wasm'],
        }),
        new webpack.ProvidePlugin({
            process: 'process/browser.js',
            Buffer: ['buffer', 'Buffer'],
        }),
    ],
    resolve: {
        fallback: { buffer: require.resolve('buffer/') },
    },
    output: {
        publicPath: '/',
    },
}
