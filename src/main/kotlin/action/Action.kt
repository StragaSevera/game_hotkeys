package action

import kotlinx.coroutines.*
import java.awt.Robot
import javax.swing.KeyStroke

abstract class Action {
    abstract val keys: List<String>
    protected val robot = Robot()

    private lateinit var job: Job
    abstract suspend fun action()

    abstract suspend fun finalizer()
    fun start(scope: CoroutineScope) {
        job = scope.launch(Dispatchers.IO) {
            action()
        }
    }

    fun stop(scope: CoroutineScope) {
        require(::job.isInitialized)
        job.cancel()
        scope.launch(Dispatchers.IO) {
            finalizer()
        }
    }

    fun getStrokes() = keys.flatMap { listOf(it, "shift $it") }.map { KeyStroke.getKeyStroke(it) }
}