import c14.sortingAlgorithms.bubbleSort
import c14.sortingAlgorithms.selectionSort
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
        println("Bubble sorted: $list")
    }
}
