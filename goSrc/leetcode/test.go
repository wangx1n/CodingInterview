package main

import (
	"fmt"
	"unsafe"
)

func main() {
	var (
		a []int
		b = make([][]int, 3)
		c = new([]int)
	)
	fmt.Println(a, b, c)
	fmt.Println(unsafe.Sizeof(c))
	fmt.Println(a, c)
	fmt.Println(unsafe.Sizeof(a))
	fmt.Println(unsafe.Sizeof(*c))
}
