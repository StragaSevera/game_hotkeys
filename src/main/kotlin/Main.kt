import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import sun.misc.Signal


fun main() = runBlocking {
//    launch(Dispatchers.Default) {
    launch {
        val app = Application(this)
        app.start()

        Signal.handle(Signal("INT")) {
            println("Interrupted by Ctrl+C")
            app.stop()
        }
    }.join()
}