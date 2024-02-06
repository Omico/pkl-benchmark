import me.omico.gradm.dependency.Kotlinx

plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
    id("org.jetbrains.kotlinx.benchmark")
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

benchmark {
    targets {
        register("main")
    }
}

dependencies {
    implementation(project(":pklbenchmark-shared"))
    implementation(Kotlinx.benchmark.runtime)
}
