package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.KeyEvent

class WalkAction : Action() {
    override val loopTime: Long = 500
    override val keys = listOf("ctrl NUMPAD2")

    override suspend fun action() {
        robot.keyPress(KeyEvent.VK_W)
        while (true) {
            delay(loopTime)
        }
    }

    override suspend fun finalizer() {
        robot.keyRelease(KeyEvent.VK_W)
    }
}