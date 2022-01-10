package com.boycoder.processor

import java.io.File

class TextProcessorV1 {
    fun processFile(file: File): List<WordFreq> {
        val text = file.readText(Charsets.UTF_8)
        return processText(text)
    }

    fun processText(text: String): List<WordFreq> {
        val cleaned = clean(text)

        val words = cleaned.split(" ")

        val map = getWordCount(words)

        val list = sortByFrequency(map)

        return list
    }

    private fun clean(text: String): String {
        return text.replace("[^A-Za-z]".toRegex(), " ")
            .trim()
    }

    private fun getWordCount(list: List<String>): Map<String, Int> {
        val map = hashMapOf<String, Int>()

        for (word in list) {
            if (word == "") continue
            val trim = word.trim()
            val count = map.getOrDefault(trim, 0)
            map[trim] = count + 1
        }

        return map
    }

    private fun sortByFrequency(map: Map<String, Int>): MutableList<WordFreq> {
        val list = mutableListOf<WordFreq>()
        for (entry in map) {
            if (entry.key == "") continue
            val freq = WordFreq(entry.key, entry.value)
            list.add(freq)
        }

        list.sortByDescending {
            it.frequency
        }

        return list
    }
}

data class WordFreq(val word: String, val frequency: Int)

fun main() {
//    val text = "Kotlin is my favorite language. I love Kotlin!"
//    val result = TextProcessorV1().processText(text)
//    println(result)
    val result = TextProcessorV1().processFile(File("./test-text.txt"))
    println(result)
}

