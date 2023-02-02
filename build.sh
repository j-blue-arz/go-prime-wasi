tinygo build -o prime.wasm -target wasi -no-debug -opt=z main.go
cp prime.wasm browser/src
cp prime.wasm graalvm/src