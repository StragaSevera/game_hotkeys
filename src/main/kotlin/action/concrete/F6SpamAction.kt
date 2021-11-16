package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.KeyEvent

class F6SpamAction : Action() {
    override val loopTime: Long = 50
    override val keys = listOf("NUMPAD7")

    override suspend fun action() {
        while (true) {
            robot.keyPress(KeyEvent.VK_F6)
            delay(loopTime)
            robot.keyRelease(KeyEvent.VK_F6)
        }
    }

    override suspend fun finalizer() {}
}