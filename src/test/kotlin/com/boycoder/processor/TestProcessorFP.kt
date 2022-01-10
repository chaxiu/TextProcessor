package com.boycoder.processor

import kotlin.test.Test
import kotlin.test.assertEquals

class TestProcessorFP {
    @Test
    fun testProcessText() {
        val text = "Kotlin is my favorite languages. I love Kotlin!"
        val results = processText(text)
        assertEquals(2, results[0].frequency)
        assertEquals("Kotlin", results[0].word)
    }
}