package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.MouseEvent

class LeftHoldAction : Action() {
    override val loopTime: Long = 500
    override val keys = listOf("NUMPAD4")

    override suspend fun action() {
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
        while (true) {
            delay(loopTime)
        }
    }

    override suspend fun finalizer() {
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
    }
}