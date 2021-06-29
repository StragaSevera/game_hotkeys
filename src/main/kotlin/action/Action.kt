package action

import kotlinx.coroutines.*
import java.awt.Robot
import javax.swing.KeyStroke

abstract class Action {
    abstract val loopTime: Long
    abstract val keys: List<String>

    protected val robot = Robot()
    private var job: Job? = null

    abstract suspend fun action()
    abstract suspend fun finalizer()

    fun start(scope: CoroutineScope) {
        job = scope.launch(Dispatchers.IO) {
            action()
        }
    }

    fun stop(scope: CoroutineScope) {
        job?.let {
            it.cancel()
            scope.launch(Dispatchers.IO) {
                finalizer()
            }
        } ?: throw IllegalStateException()
    }

    fun getStrokes() = keys.flatMap { listOf(it, "shift $it") }.map { KeyStroke.getKeyStroke(it) }
}