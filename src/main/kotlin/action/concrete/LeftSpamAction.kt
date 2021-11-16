package action.concrete

import action.Action
import kotlinx.coroutines.delay
import java.awt.event.MouseEvent

class LeftSpamAction : Action() {
    override val loopTime: Long = 50
    override val keys = listOf("ctrl NUMPAD4")

    override suspend fun action() {
        while (true) {
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
            delay(loopTime)
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
        }
    }

    override suspend fun finalizer() {}
}