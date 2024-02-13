package c14.sortingAlgorithms

import utils.swapAt

fun <T:Comparable<T>> ArrayList<T>.insertionSort(
    showPasses: Boolean = false
) {
    if (this.size < 2) return
    for (current in 1 until this.size) {
        for (shifting in current downTo 1) {
            if (this[shifting]  < this[shifting - 1]) {
                this.swapAt(shifting, shifting - 1)
            } else break
        }
        if (showPasses) println(this)
    }
}
