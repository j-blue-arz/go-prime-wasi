package main

import (
	"fmt"
	"math/big"
	"os"
)

func main() {
	number := new(big.Int)
	_, err := fmt.Sscan(os.Args[1], number)
	if err != nil {
		fmt.Printf("error scanning value: %s\n", err.Error())
	} else {
		isPrime := number.ProbablyPrime(10)
		if isPrime {
			fmt.Printf("%s is probably prime\n", os.Args[1])
		} else {
			fmt.Printf("%s is not prime\n", os.Args[1])
		}
	}
}
