package topics

fun main() {
//    println(testSimple(2, 3))
//    println(testString(10))
//
//    testNamedArguments(y = 4, z = 2, x = 5)
//
//    testDefaultArguments()
//    testDefaultArguments(x = 7)
//    testDefaultArguments(3, 5)

    println(foo(toUpperCase = true, name = "Bob"))
    printEven(1, 2, 3, 4, 5, 6, 7, 8)
    printEven(*intArrayOf(1, 2, 3, 4, 5, 6), 8, 9, 10)
}

fun testSimple(x: Int, y: Int) = x + y

fun testString(x: Int): String {
    return "String is $x";
}

fun testNamedArguments(x: Int, y: Int, z: Int): List<Int> {
    return listOf(x, y, z)
}

fun testDefaultArguments(x: Int = 1, y: Int = 2) {
    println(x + y)
}

fun foo(name: String = "Jack", number: Int = 42, toUpperCase: Boolean = false) : String {
    val s = (if (toUpperCase) name.uppercase() else name) + number
    return s
}

fun printEven(vararg numbers: Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}