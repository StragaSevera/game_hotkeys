package binding

import kotlinx.coroutines.delay
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import javax.swing.KeyStroke

class BindingsList  {
    private val robot = Robot()

    val defaultBinding = Binding("NUMPAD5") {
        while (true) {
            delay(500)
        }
    }

    private val bindingsList = listOf(
        defaultBinding,
        Binding("NUMPAD2") {
            try {
                robot.keyPress(KeyEvent.VK_W)
                robot.mousePress(MouseEvent.BUTTON1_MASK)
                while (true) {
                    delay(500)
                }
            } finally {
                robot.mouseRelease(MouseEvent.BUTTON1_MASK)
                robot.keyRelease(KeyEvent.VK_W)
            }
        },
        Binding("NUMPAD3") {
            try {
                robot.keyPress(KeyEvent.VK_W)
                robot.keyPress(KeyEvent.VK_SHIFT)
                robot.mousePress(MouseEvent.BUTTON1_MASK)
                while (true) {
                    delay(500)
                }
            } finally {
                robot.mouseRelease(MouseEvent.BUTTON1_MASK)
                robot.keyRelease(KeyEvent.VK_W)
                robot.keyRelease(KeyEvent.VK_SHIFT)
            }
        }
    )

    val bindings = mutableMapOf<KeyStroke, Binding>().also { bindingsMap ->
        for (binding in bindingsList) {
            binding.strokes.forEach { bindingsMap[it] = binding }
        }
    }
}