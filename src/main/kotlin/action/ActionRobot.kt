package action

import java.awt.Robot

object ActionRobot {
    private val robot = Robot()

    fun keyPress(key: Int) {
        robot.keyPress(key)
    }

    fun keyRelease(key: Int) {
        robot.keyRelease(key)
    }

    fun mousePress(key: Int) {
        robot.mousePress(key)
    }

    fun mouseRelease(key: Int) {
        robot.mouseRelease(key)
    }
}