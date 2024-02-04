import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.properties.Properties
import kotlinx.serialization.properties.decodeFromStringMap
import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.system.measureTimeMillis

@OptIn(ExperimentalSerializationApi::class)
fun main() {
    measureTimeMillis {
        val map = Path("benchmark.properties").readLines()
            .associate { line -> line.split("=").let { it[0] to it[1] } }
        val properties = Properties.decodeFromStringMap<BenchmarkProperties>(map)
        println(properties.a.b.c.d)
    }.let { println("Time: $it ms") }
}
