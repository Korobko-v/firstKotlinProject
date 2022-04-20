package topics

fun main() {
    val  a = listOf(1, 2, 3, 4, 5)
    a.forEach { e -> println(e)}
    println(a.map { e-> e * 2 })
    println(a.filter { e -> e % 2 == 0 })
    println(a.reduce {sum, e-> sum *   e})

    a.sortedByDescending { it }

    a.any {it > 10}

    a.all { it < 10 }
    a.sum()

    val numbers = listOf(1, 3, -4, 2, -11)
    val (positive, negative) = numbers.partition { it > 0 }
    println(positive)
    println(negative)

    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }
    println(result)
}