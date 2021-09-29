package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class RightSpamAction : Action() {
    override val loopTime: Long = 100
    override val keys = listOf("NUMPAD9")

    override suspend fun action() {
        while (true) {
            robot.mousePress(MouseEvent.BUTTON2_DOWN_MASK)
            delay(loopTime)
            robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK)
        }
    }

    override suspend fun finalizer() {}
}