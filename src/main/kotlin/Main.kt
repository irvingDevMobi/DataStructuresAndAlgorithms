import c14.sortingAlgorithms.*
import utils.example

fun main() {
    "bubble sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.bubbleSort(true)
        println("Bubble sorted: $list")
    }
    "selection sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.selectionSort(true)
        println("Selection sorted: $list")
    }
    "insertion sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original: $list")
        list.insertionSort(true)
        println("Insertion sorted: $list")
    }
    "Challenge 1: move all given value to the right" example {
        val list = arrayListOf(9, 3, 3, 7, 10, 3)
        //val list = arrayListOf<Int>()
        val valueToMove = 3
        println("Original: $list")
        list.moveAllToTheRight(valueToMove)
        println("After moving all $valueToMove to the right:")
        println(list)
    }
    "Challenge 1: Book solution" example {
        val list = arrayListOf(9, 3, 3, 7, 10, 3)
        val valueToMove = 3
        println("Original: $list")
        list.rightAlign(valueToMove)
        println("After moving all $valueToMove to the right:")
        println(list)
    }
    "Challenge 2: Return the largest element that’s a duplicate in a list" example {
        val list = arrayListOf(9, 3, 7, 9, 3, 7, 10, 3)
        println(list)
        println("Largest repeated: ${list.getLargestDuplicated()}")
    }
    "Challenge 3: Reverse a list of elements by hand" example {
        val list = arrayListOf(9, 1, 7, 2, 4, 10, 3)
        println("Original: $list")
        list.myReverse()
        println("Reversed: $list")
    }
    "Challenge 3: Book solution" example {
        val list = arrayListOf(9, 1, 7, 2, 4, 10, 3)
        println("Original: $list")
        list.bookReverse()
        println("Reversed: $list")
    }
}
