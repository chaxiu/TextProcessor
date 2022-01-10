package com.boycoder.processor

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
open class InlineBenchmark {

    fun foo(block: () -> Unit) {
        block()
    }

    inline fun fooInline(block: () -> Unit) {
        block()
    }

    @Benchmark
    fun testNonInlined() {
        var i = 0
        foo {
            foo {
                foo {
                    foo {
                        foo {
                            foo {
                                foo {
                                    foo {
                                        foo {
                                            foo {
                                                i++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Benchmark
    fun testInlined() {
        var i = 0
        fooInline {
            fooInline {
                fooInline {
                    fooInline {
                        fooInline {
                            fooInline {
                                fooInline {
                                    fooInline {
                                        fooInline {
                                            fooInline {
                                                i++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun main() {

    val options = OptionsBuilder()
        .include(InlineBenchmark::class.java.simpleName)
        .output("inline.txt")
        .build()
    Runner(options).run()
}