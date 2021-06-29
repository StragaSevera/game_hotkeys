package action

import kotlinx.coroutines.delay
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent

class SlowWalkMineAction : Action() {
    override val keys: List<String>
        get() = listOf("NUMPAD3")

    override suspend fun action() {
        ActionRobot.keyPress(KeyEvent.VK_W)
        ActionRobot.keyPress(KeyEvent.VK_SHIFT)
        ActionRobot.mousePress(MouseEvent.BUTTON1_DOWN_MASK)
        while (true) {
            delay(500)
        }
    }

    override suspend fun finalizer() {
        ActionRobot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK)
        ActionRobot.keyRelease(KeyEvent.VK_W)
        ActionRobot.keyRelease(KeyEvent.VK_SHIFT)
    }
}