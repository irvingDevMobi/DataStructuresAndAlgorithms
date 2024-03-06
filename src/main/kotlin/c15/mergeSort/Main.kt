package c15.mergeSort

import utils.example

fun main() {
    "merge sort" example {
        val list = listOf(7, 2, 6, 3, 9)
        println("Original: $list")
        val result = list.mergeSort()
        println("Merge sorted: $result")
    }
}
