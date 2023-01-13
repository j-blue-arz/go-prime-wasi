tinygo build -o prime.wasm -target wasi main.go
cp prime.wasm browser/src
cp prime.wasm graalvm/prime/src