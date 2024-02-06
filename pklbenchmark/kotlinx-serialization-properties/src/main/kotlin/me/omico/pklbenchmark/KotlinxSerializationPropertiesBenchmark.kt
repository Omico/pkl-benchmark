package me.omico.pklbenchmark

import kotlinx.benchmark.Setup
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.properties.Properties
import kotlinx.serialization.properties.decodeFromStringMap
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

@OptIn(ExperimentalSerializationApi::class)
@State(Scope.Benchmark)
class KotlinxSerializationPropertiesBenchmark {
    private lateinit var preParsedMap: Map<String, String>

    @Setup
    fun setup() {
        preParsedMap = readPropertyMap()
    }

    @Benchmark
    fun testOnDemandMap(): String = Properties.decodeFromStringMap<BenchmarkProperties>(readPropertyMap()).a.b.c.d

    @Benchmark
    fun testWithPreParsedMap(): String = Properties.decodeFromStringMap<BenchmarkProperties>(preParsedMap).a.b.c.d

    private fun readPropertyMap(): Map<String, String> =
        Resources.propertiesStream().bufferedReader().lineSequence()
            .associate { line -> line.split('=').let { it[0] to it[1] } }
}
