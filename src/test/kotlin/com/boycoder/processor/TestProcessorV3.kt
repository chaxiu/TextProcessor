package com.boycoder.processor

import kotlin.test.Test
import kotlin.test.assertEquals

class TestProcessorV3 {
    @Test
    fun testProcessText() {
        val text = "Kotlin is my favorite languages. I love Kotlin!"
        val processor = TextProcessorV3()
        val results = processor.processText(text)
        assertEquals(2, results[0].frequency)
        assertEquals("Kotlin", results[0].word)
    }
}