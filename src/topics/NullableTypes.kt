package topics

fun main() {
    var a: String = "Hello"
    var b: String? = "Test"
    b = null

    println(a.length)
    println(b?.length)

    //Elvis оператор
    //Если l = null, length вернёт -1
    val l = b?.length ?: -1

    b = if ((0..10).random() > 5) "asdg" else null
        //!! - NPE, если в переменной null
    val t = b!!.length

    println(b)
    println(t)
}