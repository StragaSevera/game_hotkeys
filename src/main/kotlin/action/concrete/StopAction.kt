package action.concrete

import action.Action
import kotlinx.coroutines.delay

class StopAction : Action() {
    override val loopTime: Long = 500
    override val keys = listOf("NUMPAD5", "CLEAR")

    override suspend fun action() {
        while (true) {
            delay(loopTime)
        }
    }

    override suspend fun finalizer() = Unit
}