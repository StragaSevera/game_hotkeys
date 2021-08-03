package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class RightHoldAction : Action() {
    override val loopTime: Long = 500
    override val keys = listOf("NUMPAD6")

    override suspend fun action() {
        robot.mousePress(MouseEvent.BUTTON2_DOWN_MASK)
        while (true) {
            delay(loopTime)
        }
    }

    override suspend fun finalizer() {
        robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK)
    }
}