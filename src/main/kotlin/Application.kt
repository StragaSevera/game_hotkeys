import action.Action
import action.ActionsList
import com.tulskiy.keymaster.common.Provider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Application(val scope: CoroutineScope) {
    private val provider: Provider = Provider.getCurrentProvider(false)
    private val bindingsList = ActionsList()
    private lateinit var current: Action

    fun start() {
        for ((stroke, binding) in bindingsList.bindings) {
            provider.register(stroke) { scope.launch { handlePress(binding) } }
        }
        startBinding(bindingsList.defaultAction, scope)
    }

    fun stop() {
        current.stop(scope)
        provider.reset()
        provider.stop()
    }

    private suspend fun handlePress(action: Action) {
        coroutineScope {
            current.stop(this)
            delay(510)
            startBinding(action, scope)
        }
    }

    private fun startBinding(action: Action, scope: CoroutineScope) {
        current = action
        current.start(scope)
    }
}