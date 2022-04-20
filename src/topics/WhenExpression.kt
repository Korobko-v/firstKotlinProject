package topics

fun main() {
    testWhen(1)
    testWhen(2)
    testWhen("Hello")
    testWhen(15)
    testWhen(77)
}

fun testWhen(input: Any) {
    when(input) {
        1 -> println("Единица")
        2 -> println("Двойка")
        in 10..20 -> println("От 10 до 20")
        is String -> println("Была введена строка ${input}")
        else -> println("Что-то ещё")
    }
}