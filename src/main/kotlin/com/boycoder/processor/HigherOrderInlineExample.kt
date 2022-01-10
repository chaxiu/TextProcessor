package com.boycoder.processor

inline fun fooInline(block: () -> Unit) {
    block()
}

fun main() {
    var i = 0
    fooInline{
        i++
    }
}