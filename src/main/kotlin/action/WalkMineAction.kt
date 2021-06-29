package action

import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class WalkMineAction : Action() {
    override val loopTime: Long = 500
    override val keys = listOf("NUMPAD2")

    override suspend fun action() {
        robot.keyPress(KeyEvent.VK_W)
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
        while (true) {
            delay(loopTime)
        }
    }

    override suspend fun finalizer() {
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
        robot.keyRelease(KeyEvent.VK_W)
    }
}