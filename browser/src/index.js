import { computePrime } from "./prime.js"

const computeButton = document.getElementById('compute')
computeButton.onclick = () => isPrime(7)

async function isPrime(number) {
    await computePrime()
}
