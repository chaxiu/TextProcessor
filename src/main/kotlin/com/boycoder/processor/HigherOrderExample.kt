package com.boycoder.processor

fun foo(block: () -> Unit) {
    block()
}

fun main() {
    var i = 0
    foo{
        i++
    }
}