package topics

fun main() {
    val items = listOf("apple", "banana", "orange")

    val mutableListOf = mutableListOf("apple", "banana", "orange")

    for (item in items)
        println(item)

    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    //Диапазоны
    println(5 in 3..10)

    for (i in 1..10)
        println(i)

    for (i in 1 until 10)
        println(i)

    for (i in 10 downTo 2 step 2)
        println(i)
}