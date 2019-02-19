package ch.tournamator

class App {
    val greeting: String
        get() {
            return "Hello sub-world."
        }
}

fun main(args: Array<String>) {
    println(App().greeting)
}