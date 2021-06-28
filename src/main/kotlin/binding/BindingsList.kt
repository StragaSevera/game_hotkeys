package binding

import Application
import kotlinx.coroutines.delay

class BindingsList(): Iterable<Binding> {
    val defaultBinding = Binding("NUMPAD5") {
        println("Stopped!")
        while (true) {
            delay(500)
            println("Doing nothing...")
        }
    }

    val bindings = listOf(
        defaultBinding,
        Binding("NUMPAD2") {
            println("Forwards!")
            while (true) {
                delay(500)
                println("w")
            }
        }
    )

    override fun iterator() = bindings.iterator()
}