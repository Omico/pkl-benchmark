package me.omico.pklbenchmark

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.util.Properties

@State(Scope.Benchmark)
class JavaPropertiesBenchmark {
    @Benchmark
    fun test(): String =
        Properties()
            .apply { load(Resources.propertiesStream()) }
            .getProperty("a.b.c.d")!!
}
