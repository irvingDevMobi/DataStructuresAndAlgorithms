package c16.radixSort

import kotlin.math.pow

fun MutableList<Int>.radixSort() {
    val base = 10

    var done = false
    var digits = 1
    while (!done) {
        done = true
        val buckets = MutableList<MutableList<Int>>(base) { mutableListOf() }
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)
            if (remainingPart > 0) {
                done = false
            }
        }
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
        println(this)
    }
}

fun MutableList<Int>.lexicographicalSort(
    index: Int = 0
): List<Int> {
    var done = false
    val base = 10
    val buckets = MutableList<MutableList<Int>>(base) { mutableListOf() }
    this.forEach { number ->
        val stringNumber = number.toString()
        val digit = if (index < stringNumber.length) stringNumber[index].digitToInt()
        else 0
        buckets[digit].add(number)
        if (index >= stringNumber.length) {
            done = true
        }
    }
    val validLists = buckets.filter { it.isNotEmpty() }
    val remainingCounter = validLists.sumOf { it.size }
    if (done || remainingCounter <= 1) return validLists.flatten()

    val result: MutableList<List<Int>> = mutableListOf()
    validLists.forEach {
        result.add(it.lexicographicalSort(index + 1))
    }
    return result.flatten()
}

// Book Solution
fun Int.digits(): Int {
    var count = 0
    var num = this
    while (num != 0) {
        count++
        num /= 10
    }
    return count
}

fun Int.digit(atPosition: Int): Int? {
    val correctedPosition = (atPosition + 1).toDouble()
    if (correctedPosition > digits()) return null

    var num = this
    while (num / (10.0.pow(correctedPosition).toInt()) != 0) {
        num /= 10
    }
    return num % 10
}

fun MutableList<Int>.bookLexicographicalSort() {
    val sorted = msdRadixSorted(this, 0)
    this.clear()
    this.addAll(sorted)
}

private fun msdRadixSorted(
    list: MutableList<Int>,
    position: Int = 0
): MutableList<Int> {
    if (position >= list.maxDigits()) return list

    val buckets = MutableList<MutableList<Int>>(10) { mutableListOf() }
    val priorityBucket = arrayListOf<Int>()
    list.forEach { number ->
        val digit = number.digit(position)
        if (digit == null) {
            priorityBucket.add(number)
            return@forEach
        }
        buckets[digit].add(number)
    }
    println("priorityBucket: $priorityBucket")
    println("buckets: $buckets")
    val newValues = buckets.reduce { result, bucket ->
        if (bucket.isEmpty()) return@reduce result

        result.addAll(msdRadixSorted(bucket, position + 1))
        result
    }
    priorityBucket.addAll(newValues)
    return priorityBucket
}

private fun List<Int>.maxDigits(): Int {
    return this.maxOrNull()?.digits() ?: 0
}
