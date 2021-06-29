package action

import kotlinx.coroutines.delay

class StopAction : Action() {
    override val keys: List<String>
        get() = listOf("NUMPAD5")

    override suspend fun action() {
        while (true) {
            delay(500)
        }
    }

    override suspend fun finalizer() = Unit
}