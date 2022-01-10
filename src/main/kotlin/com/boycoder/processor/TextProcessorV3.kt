package com.boycoder.processor

import kotlin.collections.HashMap

class TextProcessorV3 {
    fun processText(text: String): List<WordFreq> {
        return text
            .clean()
            .split(" ")
            .getWordCount()
            .mapToList { WordFreq(it.key, it.value) }
            .sortedByDescending { it.frequency }
    }

    private inline fun <T> Map<String, Int>.mapToList(transform: (Map.Entry<String, Int>) -> T): MutableList<T> {
        val list = mutableListOf<T>()
        for (entry in this) {
            val freq = transform(entry)
            list.add(freq)
        }
        return list
    }


    private fun List<String>.getWordCount(): Map<String, Int> {
        val map = HashMap<String, Int>()
        for (element in this) {
            if (element == "") continue
            val trim = element.trim()
            val count = map.getOrDefault(trim, 0)
            map[trim] = count + 1
        }
        return map
    }
}

fun main() {
    var i = 0
    foo{
        i++
    }
}
