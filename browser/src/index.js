import { computePrime } from './prime.js'

const numberInput = document.getElementById('number')
const computeButton = document.getElementById('compute')
const outputDiv = document.getElementById('output')
computeButton.onclick = () => onClickCompute()

async function onClickCompute() {
    if (numberInput.reportValidity()) {
        const value = numberInput.value
        const result = await computePrime(value)
        outputDiv.textContent = result
    }
}
