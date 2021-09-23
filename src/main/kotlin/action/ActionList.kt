package action

import action.concrete.*
import javax.swing.KeyStroke

class ActionList {
    val defaultAction = StopAction()

    private val actionsList = listOf(
        defaultAction,
        WalkAction(),
        WalkMineAction(),
        SlowWalkMineAction(),
        LeftHoldAction(),
        LeftSpamAction(),
        LeftSlowSpamAction(),
        RightHoldAction(),
        RightSpamAction()
    )

    val bindings = mutableMapOf<KeyStroke, Action>().also { bindingsMap ->
        for (action in actionsList) {
            action.getStrokes().forEach { bindingsMap[it] = action }
        }
    }
}