import org.pkl.config.java.ConfigEvaluator
import org.pkl.config.kotlin.forKotlin
import org.pkl.config.kotlin.to
import org.pkl.core.ModuleSource
import kotlin.io.path.Path
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        val evaluator = ConfigEvaluator.preconfigured().forKotlin()
        evaluator.use {
            val config = it.evaluate(ModuleSource.path(Path("benchmark.pkl")))
            println(config["a"]["b"]["c"]["d"].to<String>())
        }
    }.let { println("Time: $it ms") }
}
