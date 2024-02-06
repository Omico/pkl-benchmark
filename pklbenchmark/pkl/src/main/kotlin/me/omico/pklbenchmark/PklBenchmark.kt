package me.omico.pklbenchmark

import kotlinx.benchmark.Setup
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.pkl.config.java.ConfigEvaluator
import org.pkl.config.kotlin.forKotlin
import org.pkl.config.kotlin.to
import org.pkl.core.ModuleSource

@State(Scope.Benchmark)
class PklBenchmark {
    private lateinit var evaluator: ConfigEvaluator

    @Setup
    fun setup() {
        evaluator = ConfigEvaluator.preconfigured().forKotlin()
    }

    @Benchmark
    fun testCreateEvaluatorOnDemand(): String =
        ConfigEvaluator.preconfigured().forKotlin()
            .use { it.evaluate(pklSource()) }
            .let { it["a"]["b"]["c"]["d"].to<String>() }

    @Benchmark
    fun testUsePreconfiguredEvaluator(): String =
        evaluator.evaluate(pklSource())["a"]["b"]["c"]["d"].to<String>()

    private fun pklSource(): ModuleSource =
        Resources.pklStream().bufferedReader().readText()
            .let(ModuleSource::text)
}
