package c16.radixSort

import utils.example

fun main() {
    "radix sort" example {
        val list = arrayListOf(88, 410, 1772, 20)
        println("Original: $list")
        list.radixSort()
        println("Radix sorted: $list")
    }
    "Challenge 1: Most significant sort" example {
        //val list = arrayListOf(500, 1345, 13, 459, 44, 999)
        val list = mutableListOf(448, 3168, 6217, 7117, 1256, 3887, 3900, 3444, 4976, 6891, 4682)
        val result = list.lexicographicalSort()
        println(result) // outputs [13, 1345, 44, 459, 500, 999]
    }
    "MSD radix sort" example {
        //val list = (0..10).map { (Math.random() * 10000).toInt() }.toMutableList()
        //val list = mutableListOf(448, 3168, 6217, 7117, 1256, 3887, 3900, 3444, 4976, 6891, 4682)
        val list = arrayListOf(500, 1345, 13, 459, 44, 999)
        println("Original: $list")
        list.bookLexicographicalSort()
        println("Radix sorted: $list")
    }
}
