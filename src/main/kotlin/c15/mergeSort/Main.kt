package c15.mergeSort

import utils.example

fun main() {
    "merge sort" example {
        val list = listOf(7, 2, 6, 3, 9)
        println("Original: $list")
        val result = list.mergeSort()
        println("Merge sorted: $result")
    }
    "Challenge 1: Iterable" example {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val list2 = listOf(1, 3, 4, 5, 5, 6, 7, 7)
        val result = merge(list1, list2)
        println("Merge Iterables: $result")
    }
    "merge iterables" example {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val list2 = listOf(1, 3, 4, 5, 5, 6, 7, 7)
        val result = bookMerge(list1, list2)
        println("Merged: $result")
    }
}
