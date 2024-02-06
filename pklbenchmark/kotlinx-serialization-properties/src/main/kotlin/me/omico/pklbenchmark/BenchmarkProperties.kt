package me.omico.pklbenchmark

import kotlinx.serialization.Serializable

@Serializable
data class BenchmarkProperties(
    val a: A,
) {
    @Serializable
    data class A(
        val b: B,
    ) {
        @Serializable
        data class B(
            val c: C,
        ) {
            @Serializable
            data class C(
                val d: String,
            )
        }
    }
}
