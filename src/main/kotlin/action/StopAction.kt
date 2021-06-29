package action

import kotlinx.coroutines.delay

class StopAction : Action() {
    override val loopTime: Long = 500
    override val keys = listOf("NUMPAD3")

    override suspend fun action() {
        while (true) {
            delay(loopTime)
        }
    }

    override suspend fun finalizer() = Unit
}