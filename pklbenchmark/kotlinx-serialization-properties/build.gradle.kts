plugins {
    id("pklbenchmark.benchmark")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(kotlinx.serialization.properties)
}
