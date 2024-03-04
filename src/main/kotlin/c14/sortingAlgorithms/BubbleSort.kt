package c14.sortingAlgorithms

import utils.swapAt

fun <T : Comparable<T>> MutableList<T>.bubbleSort(
    showPasses: Boolean = false
) {
    if (this.size < 2) return

    for (end in this.lastIndex downTo 1) {
        var swapped = false
        for(current in 0 until end) {
            if (this[current] > this[current + 1]) {
                this.swapAt(current, current + 1)
                swapped = true
            }
        }
        if (showPasses) println(this)
        if (!swapped) return
    }
}
