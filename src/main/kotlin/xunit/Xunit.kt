package xunit

fun main(args: Array<String>) {
    val test = WasRun("testMethod")

    println(test.wasRun)
    test.testMethod()
    println(test.wasRun)
}

class WasRun(val path: String) {

    var wasRun: Boolean = false
        private set(value) {
            field = value
        }

    fun testMethod() {
        wasRun = true
    }
}
