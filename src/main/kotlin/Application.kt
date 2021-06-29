import action.Action
import action.ActionList
import com.tulskiy.keymaster.common.Provider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Application(private val scope: CoroutineScope) {
    private val provider: Provider = Provider.getCurrentProvider(false)
    private val actionList = ActionList()
    private lateinit var currentAction: Action

    fun start() {
        for ((stroke, action) in actionList.bindings) {
            provider.register(stroke) { scope.launch { handlePress(action) } }
        }
        startBinding(actionList.defaultAction, scope)
    }

    fun stop() {
        currentAction.stop(scope)
        provider.reset()
        provider.stop()
    }

    private suspend fun handlePress(action: Action) {
        coroutineScope {
            currentAction.stop(this)
            delay(currentAction.loopTime + 10)
            startBinding(action, scope)
        }
    }

    private fun startBinding(action: Action, scope: CoroutineScope) {
        currentAction = action
        currentAction.start(scope)
    }
}