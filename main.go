package main

import (
	"fmt"
	"math/big"
	"os"
)

func check(num string) string {
	number := new(big.Int)
	_, err := fmt.Sscan(num, number)
	if err != nil {
		return "error scanning value: " + err.Error()
	} else {
		isPrime := number.ProbablyPrime(10)
		if isPrime {
			return num + " is probably prime\n"
		} else {
			return num + " is not prime\n"
		}
	}
}

func main() {
	fmt.Println(check(os.Args[1]))
	os.Exit(0)
}
