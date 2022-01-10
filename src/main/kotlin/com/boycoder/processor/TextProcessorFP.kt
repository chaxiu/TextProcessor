package com.boycoder.processor


fun processText(text: String): List<WordFreq> {
    return text
        .clean()
        .split(" ")
        .filter { it != "" }
        .groupBy { it }
        .map { WordFreq(it.key, it.value.size) }
        .sortedByDescending { it.frequency }
}

fun main() {

}
