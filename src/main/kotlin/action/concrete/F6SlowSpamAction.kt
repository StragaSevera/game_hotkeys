package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class F6SlowSpamAction : Action() {
    override val loopTime: Long = 1000
    override val keys = listOf("ctrl NUMPAD8")

    override suspend fun action() {
        while (true) {
            robot.keyPress(KeyEvent.VK_F6)
            delay(loopTime)
            robot.keyRelease(KeyEvent.VK_F6)
        }
    }

    override suspend fun finalizer() {}
}