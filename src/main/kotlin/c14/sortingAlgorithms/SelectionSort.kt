package c14.sortingAlgorithms

import utils.swapAt

fun <T : Comparable<T>> ArrayList<T>.selectionSort(
    showPasses: Boolean = false
) {
    if (this.size < 2) return

    for (current in 0 until this.lastIndex) {
        var lowest = current
        for (other in (current + 1) until this.size) {
            if (this[other] < this[lowest]) {
                lowest = other
            }
        }
        if (lowest != current) {
            this.swapAt(lowest, current)
        }
        if (showPasses) println(this)
    }
}
