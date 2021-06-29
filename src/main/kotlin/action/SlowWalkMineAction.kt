package action

import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class SlowWalkMineAction : Action() {
    override val keys: List<String>
        get() = listOf("NUMPAD3")

    override suspend fun action() {
        robot.keyPress(KeyEvent.VK_W)
        robot.keyPress(KeyEvent.VK_SHIFT)
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
        while (true) {
            delay(500)
        }
    }

    override suspend fun finalizer() {
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
        robot.keyRelease(KeyEvent.VK_W)
        robot.keyRelease(KeyEvent.VK_SHIFT)
    }
}