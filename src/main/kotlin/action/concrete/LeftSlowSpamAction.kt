package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class LeftSlowSpamAction : Action() {
    override val loopTime: Long = 1000
    override val keys = listOf("NUMPAD7")

    override suspend fun action() {
        while (true) {
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
            delay(loopTime)
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
        }
    }

    override suspend fun finalizer() {}
}