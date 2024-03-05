package c14.sortingAlgorithms

import utils.swapAt

fun <T : Comparable<T>> MutableList<T>.moveAllToTheRight(value: T) {
    var lastDifferentValueIndex = this.size - 1
    var index = lastDifferentValueIndex
    while (index >= 0) {
        if (value == this[index]) {
            if (index != lastDifferentValueIndex) {
                for (swifting in index + 1..lastDifferentValueIndex)
                    swapAt(swifting - 1, swifting)
            }
            lastDifferentValueIndex--
        }
        index--
    }
}

fun <T : Comparable<T>> MutableList<T>.rightAlign(element: T) {
    if (this.size < 2) return

    var searchIndex = this.size - 2
    while (searchIndex >= 0) {
        if (this[searchIndex] == element) {
            var moveIndex = searchIndex
            while (moveIndex < this.size - 1 && this[moveIndex + 1] != element) {
                swapAt(moveIndex, moveIndex + 1)
                moveIndex++
            }
        }
        searchIndex--
    }
}

fun <T : Comparable<T>> MutableList<T>.getLargestDuplicated(): T? {
    val copy = this.map { it }.toMutableList()
    copy.insertionSort()
    for (index in copy.lastIndex downTo 1) {
        if (copy[index] == copy[index - 1]) return copy[index]
    }
    return null
}

fun <T : Comparable<T>> MutableList<T>.myReverse() {
    for (index in 0 until (this.size / 2)) {
        swapAt(index, this.lastIndex - index)
    }
}

fun <T : Comparable<T>> MutableList<T>.bookReverse() {
    var left = 0
    var right = this.lastIndex
    while (left < right) {
        swapAt(left, right)
        left++
        right--
    }
}
