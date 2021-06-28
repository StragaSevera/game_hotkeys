package binding

import kotlinx.coroutines.*
import javax.swing.KeyStroke

class Binding(key: String, private val action: suspend () -> Unit) {

    val stroke = KeyStroke.getKeyStroke(key)
    private lateinit var job: Job

    fun start(scope: CoroutineScope): Unit {
        job = scope.launch(Dispatchers.IO) {
            action()
        }
    }

    fun stop() {
        require(::job.isInitialized)
        job.cancel()
    }
}