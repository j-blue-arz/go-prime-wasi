## Running WASI-compliant WebAssembly in the browser

```bash
npm ci
npm run build
```

Then serve the `dist` folder with a webserver of your choice, e.g.

```
python3 -m http.server --directory dist
```
