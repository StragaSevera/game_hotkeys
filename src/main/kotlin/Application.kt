import binding.Binding
import binding.BindingsList
import com.tulskiy.keymaster.common.Provider
import kotlinx.coroutines.CoroutineScope

class Application(val scope: CoroutineScope) {
    private val provider: Provider = Provider.getCurrentProvider(false)
    private val bindingsList = BindingsList()
    private lateinit var current: Binding

    fun start() {
        for ((stroke, binding) in bindingsList.bindings) {
            provider.register(stroke) { handlePress(binding) }
        }
        startBinding(bindingsList.defaultBinding)
    }

    fun stop() {
        current.stop()
        provider.reset()
        provider.stop()
    }

    fun handlePress(binding: Binding) {
        current.stop()
        startBinding(binding)
    }

    fun startBinding(binding: Binding) {
        current = binding
        current.start(scope)
    }
}