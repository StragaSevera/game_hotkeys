package action

import javax.swing.KeyStroke

class ActionsList {
    val defaultAction = StopAction()

    private val actionsList = listOf(
        defaultAction,
        WalkMineAction(),
        SlowWalkMineAction()
    )

    val bindings = mutableMapOf<KeyStroke, Action>().also { bindingsMap ->
        for (action in actionsList) {
            action.getStrokes().forEach { bindingsMap[it] = action }
        }
    }
}