package topics

import java.math.BigInteger
import kotlin.math.abs

fun main() {
    println(productFib(5895).get(0))
    println(productFib(5895).get(1))
}


fun getAscii(c: Char): Int {
    return c.code
}

fun sum(numbers: IntArray): Int = (numbers.filter { it > 0 }).sum()
fun hero(bullets: Int, dragons: Int): Boolean = if (bullets <= 0) false else bullets / dragons >= 2

fun include(arr: IntArray, item: Int): Boolean = arr.contains(item)

fun summation(n: Int): Int {
    var sum: Int = 0
    for (i in n downTo 1)
        sum += i

    return sum
}

fun simplifiedSummation(n: Int) = (1..n).sum()

fun maps(x: IntArray): IntArray = x.map { it * 2 }.toIntArray()

fun invert(arr: IntArray): IntArray = arr.map { -it }.toIntArray()

fun makeValley(arr: IntArray): IntArray {
    var list = arr.toMutableList().sortedDescending()
    var left = mutableListOf<Int>()
    var right = mutableListOf<Int>()
    for (i in 0..arr.size - 1) if (i % 2 == 0) left.add(list.get(i)) else right.add(list.get(i))
    return (left.sortedDescending() + right.sorted()).toIntArray()
}

fun alphabetWar(fight: String): String {
    val forces = mapOf('w' to 4, 'p' to 3, 'b' to 2, 's' to 1, 'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    val result = fight.sumOf { forces.getOrDefault(it, 0) }
    return when {
        result > 0 -> "Left side wins!"
        result < 0 -> "Right side wins!"
        else -> "Let's fight again!"
    }
}

fun evenNumbers(array: List<Int>, number: Int): List<Int> = array.filter { it % 2 == 0 }.takeLast(number)

fun hidePasswordFromConnection(urlString: String): String {
//    val s = urlString.takeLastWhile { it != '=' }
//    val length = s.length
    val split = urlString.split("password=")
    var index = split[1].length
    if (split[1].contains("&")) {
        index = split[1].indexOf("&")
    }

    return split[0] + "password=" + split[1].replaceRange(
        0 until index,
        "*".repeat(index)
    )
}

fun outed(meet: Map<String, Int>, boss: String): String {
    var mutableMeet = meet.toMutableMap()
    var bossRate = meet.get(boss)!! * 2
    mutableMeet.replace(boss, meet.get(boss)!!, bossRate)
    println(mutableMeet.get(boss))
    println("Average is: ${sum(mutableMeet.values.toIntArray()) / mutableMeet.size}")
    if (mutableMeet.values.toIntArray()
            .sum() / mutableMeet.size <= 5
    ) return "Get Out Now!" else return "Nice Work Champ!"
}

fun easyLine(n: Int): BigInteger {
    val triangle: MutableList<MutableList<BigInteger>> = mutableListOf()
    for (i in 0..n) {
        val list: MutableList<BigInteger> = mutableListOf()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                list.add(BigInteger.ONE)
            } else {
                val previousLine = triangle.get(i - 1)
                list.add((previousLine.get(j - 1) + previousLine.get(j)))
            }
        }
        triangle.add(list)
    }
    return (triangle.get(n).sumOf { it * it })
}

fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
    var max = 0
    if (a1.isEmpty() || a2.isEmpty()) return -1
    for (i in a1) {
        for (j in a2) {
            var dif = abs(i.length - j.length)
            if (dif > max) max = dif
        }
    }
    return max
}

fun abbrevName(name: String) =
    name.split(" ").get(0).get(0).uppercase() + "." + name.split(" ").get(1).get(0).uppercase()

fun litres(time: Double): Int = Math.floor(0.5 * time).toInt()

fun highAndLow(numbers: String): String {
    val digits = numbers.split(" ").map { it.toInt() }.sorted()
    return "${digits.last()} ${digits.first()}"
}

fun findShort(s: String): Int = s.split(" ").minOf { it.length }

fun capitalize(text: String): List<String> {
//    var a1 = ""
//    var a2 = ""
//    for (i in text.indices) {
//        if (i % 2 == 0) {
//            a1 += text.get(i).uppercase()
//            a2 += text.get(i)
//        } else {
//            a1 += text.get(i)
//            a2 += text.get(i).uppercase()
//        }
//    }
//    return listOf(a1, a2)
    return listOf(
        text.mapIndexed { index, c -> if (index % 2 == 0) c.uppercase() else c }.joinToString { "" },
        text.mapIndexed { index, c -> if (index % 2 != 0) c.uppercase() else c }.joinToString { "" }
    )
}

fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int {
    var contentLeft = content
    var days = 0
    while (contentLeft >= content * threshold / 100) {
        contentLeft *= (1 - evap_per_day / 100)
        days++
    }
    return days;
}

fun longToIP(ip: UInt): String {
    var binary = ip.toString(2)
    while (binary.length < 32) {
        binary = "0" + binary
    }
    var octet1: String
    var octet2: String
    var octet3: String
    var octet4: String

        octet1 = binary.substring(0, 8)
        octet2 = binary.substring(8, 16)
        octet3 = binary.substring(16, 24)
        octet4 = binary.substring(24)

    return "${binaryToDecimal(octet1)}.${binaryToDecimal(octet2)}.${binaryToDecimal(octet3)}.${binaryToDecimal(octet4)}"
}

fun simplifiedLongToIP(ip: UInt): String {
    return ip.toString(2).padStart(32, '0').chunked(8).map { it.toInt(2) }.joinToString { "." }
}

fun simpleLongToIP(x: UInt) = (0..24 step 8).map { x shr it and 255u }.reversed().joinToString(".")

fun binaryToDecimal(bin: String): Int {
    var decimal: Int = 0
    var reversed: String = bin.reversed()

    for (i in bin.indices) {
        decimal += ((reversed.get(i) + "").toInt()) * Math.pow(2.0, i.toDouble()).toInt()
    }
    return decimal
}

fun productFib(prod:Long):LongArray {
    val list = mutableListOf<Long>(0, 1)
    var multiplication = 0L
    var n: Int
    while (multiplication < prod) {
        n = list.size - 1
        multiplication = list.get(n) * list.get(n-1)
        if (multiplication == prod) {
            return longArrayOf(list.get(n-1), list.get(n), 1)
        }
        if (multiplication > prod) {
            return longArrayOf(list.get(n-1), list.get(n), 0)
        }
        list.add(list.get(n-1) + list.get(n))
    }
    return longArrayOf(0, 0, 0)

//    var (a, b, check) = longArrayOf(0, 1, 0)
//    while (check < prod) {
//        a = b.also { b += a }
//        check = a * b
//    }
//    return longArrayOf(a, b, if (check == prod) 1L else 0L)
}

fun beggars(values: List<Int>, n: Int): List<Int> {
    return mutableListOf()
}

