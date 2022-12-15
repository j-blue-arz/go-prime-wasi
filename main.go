package main

import (
	"fmt"
	"math/big"
	"os"
)

//go:export checkstr
func checkstr(num string) string {
	number := new(big.Int)
	_, err := fmt.Sscan(os.Args[1], number)
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

//go:export checknum
func checknum(num int64) bool {
	number := big.NewInt(num)
	return number.ProbablyPrime(10)
}

func main() {
	print(checkstr("7"))
}
