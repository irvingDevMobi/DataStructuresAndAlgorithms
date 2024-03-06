package c15.mergeSort

fun <T : Comparable<T>> merge(
    first: Iterable<T>,
    second: Iterable<T>
): Iterable<T> {
    val firstIterator = first.iterator()
    val secondIterator = second.iterator()

    if (!firstIterator.hasNext()) return second
    if (!secondIterator.hasNext()) return first

    val mutableList = mutableListOf<T>()
    var leftElement: T? = firstIterator.next()
    var rightElement: T? = secondIterator.next()

    while (leftElement != null && rightElement != null) {
        if (leftElement < rightElement) {
            mutableList.add(leftElement)
            leftElement = if (firstIterator.hasNext()) firstIterator.next() else null
        } else if (leftElement > rightElement) {
            mutableList.add(rightElement)
            rightElement = if (secondIterator.hasNext()) secondIterator.next() else null
        } else {
            mutableList.add(leftElement)
            leftElement = if (firstIterator.hasNext()) firstIterator.next() else null
            mutableList.add(rightElement)
            rightElement = if (secondIterator.hasNext()) secondIterator.next() else null
        }
    }
    leftElement?.let { mutableList.add(it) }
    rightElement?.let { mutableList.add(it) }
    while (firstIterator.hasNext()) {
        mutableList.add(firstIterator.next())
    }
    while (secondIterator.hasNext()) {
        mutableList.add(secondIterator.next())
    }
    return mutableList.asIterable()
}


private fun <T> Iterator<T>.nextOrNull(): T? =
    if (this.hasNext()) this.next() else null

fun <T : Comparable<T>> bookMerge(
    first: Iterable<T>,
    second: Iterable<T>
): Iterable<T> {
    val result = mutableListOf<T>()
    val firstIterator = first.iterator()
    val secondIterator = second.iterator()

    if (!firstIterator.hasNext()) return second
    if (!secondIterator.hasNext()) return first

    var firstElement = firstIterator.nextOrNull()
    var secondElement = secondIterator.nextOrNull()

    while (firstElement != null && secondElement != null) {
        when {
            firstElement < secondElement -> {
                result.add(firstElement)
                firstElement = firstIterator.nextOrNull()
            }
            firstElement > secondElement -> {
                result.add(secondElement)
                secondElement = secondIterator.nextOrNull()
            }
            else -> {
                result.add(firstElement)
                firstElement = firstIterator.nextOrNull()
                result.add(secondElement)
                secondElement = secondIterator.nextOrNull()
            }
        }
    }
    while (firstElement != null) {
        result.add(firstElement)
        firstElement = firstIterator.nextOrNull()
    }
    while (secondElement != null) {
        result.add(secondElement)
        secondElement = secondIterator.nextOrNull()
    }
    return result
}
