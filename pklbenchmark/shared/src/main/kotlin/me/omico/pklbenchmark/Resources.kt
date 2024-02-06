package me.omico.pklbenchmark

import java.io.InputStream

object Resources {
    fun pklStream(): InputStream = loadResourceStream("benchmark.pkl")
    fun propertiesStream(): InputStream = loadResourceStream("benchmark.properties")

    private fun loadResourceStream(name: String): InputStream = javaClass.classLoader.getResourceAsStream(name)!!
}
