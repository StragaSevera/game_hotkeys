package binding

import kotlinx.coroutines.*
import javax.swing.KeyStroke

class Binding(keys: List<String>, private val action: suspend () -> Unit) {
    constructor(vararg keys: String, action: suspend () -> Unit) : this(keys.toList(), action)

    val strokes = keys.flatMap { listOf(it, "shift $it") }.map { KeyStroke.getKeyStroke(it) }
    private lateinit var job: Job

    fun start(scope: CoroutineScope) {
        job = scope.launch(Dispatchers.IO) {
            action()
        }
    }

    fun stop() {
        require(::job.isInitialized)
        job.cancel()
    }
}