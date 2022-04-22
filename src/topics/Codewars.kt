package topics

import java.math.BigInteger
import kotlin.math.abs

fun main() {
    val friends1 = arrayOf("A1", "A3", "A4", "A5")
    val fTowns1 = arrayOf(arrayOf("A1", "X1"), arrayOf("A2", "X2"), arrayOf("A3", "X3"), arrayOf("A4", "X4"))
    val distTable1: MutableMap<String, Double> = HashMap()
    distTable1["X1"] = 100.0
    distTable1["X2"] = 200.0
    distTable1["X3"] = 250.0
    distTable1["X4"] = 300.0
    println(tour(friends1, fTowns1, distTable1))

    val friends2 = arrayOf("A1", "A2", "A3", "A4", "A5", "A6")
    val fTowns2 = arrayOf(arrayOf("A1", "X1"), arrayOf("A2", "X2"), arrayOf("A3", "X3"), arrayOf("A4", "X4"), arrayOf("A5", "X5"))
    val distTable2: MutableMap<String, Double> = HashMap()
    distTable2["X1"] = 100.0
    distTable2["X2"] = 200.0
    distTable2["X3"] = 250.0
    distTable2["X4"] = 300.0
    distTable2["X5"] = 320.0
    println(tour(friends2, fTowns2, distTable2))

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

//Born a misinterpretation of this kata, your task here is pretty simple: given an array of values and an amount of beggars, you are supposed to return an array with the sum of what each beggar brings home, assuming they all take regular turns, from the first to the last.
//
//For example: [1,2,3,4,5] for 2 beggars will return a result of [9,6], as the first one takes [1,3,5], the second collects [2,4].
//
//The same array with 3 beggars would have in turn have produced a better out come for the second beggar: [5,7,3], as they will respectively take [1,4], [2,5] and [3].
//
//Also note that not all beggars have to take the same amount of "offers", meaning that the length of the array is not necessarily a multiple of n; length can be even shorter, in which case the last beggars will of course take nothing (0).
//
//Note: in case you don't get why this kata is about English beggars, then you are not familiar on how religiously queues are taken in the kingdom ;)
//
//Note 2: do not modify the input array.
fun beggars(values: List<Int>, n: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 0 until n) {
        var sum = 0
        for (j in i until values.size step n) {
            sum += values.get(j)
        }
        list.add(sum)
    }
    return list
}

//Your granny, who lives in town X0, has friends. These friends are given in an array, for example: array of friends is ["A1", "A2", "A3", "A4", "A5"].
//
//The order of friends in this array must not be changed since this order gives the order in which they will be visited.
//
//Friends inhabit towns and you get an array with friends and their towns (or an associative array), for example: [["A1", "X1"], ["A2", "X2"], ["A3", "X3"], ["A4", "X4"]] which means A1 is in town X1, A2 in town X2... It can happen that we do not know the town of one of the friends hence it will not be visited.
//
//Your granny wants to visit her friends and to know approximately how many miles she will have to travel. You will make the circuit that permits her to visit her friends. For example here the circuit will be:X0, X1, X2, X3, X4, X0 and you will compute approximately the total distance X0X1 + X1X2 + .. + X4X0.
//
//For the distances you are given an array or a dictionary that gives each distance X0X1, X0X2 and so on. For example (it depends on the language):
//
//[ ["X1", 100.0], ["X2", 200.0], ["X3", 250.0], ["X4", 300.0] ]
//or
//("X1" -> 100.0, "X2" -> 200.0, "X3" -> 250.0, "X4" -> 300.0)
//which means that X1 is at 100.0 miles from X0, X2 at 200.0 miles from X0, etc... It's not real life, it's a story... : the towns X0, X1, .., X0 are placed in the following manner (see drawing below):
//
//X0X1X2 is a right triangle with the right angle in X1, X0X2X3 is a right triangle with the right angle in X2, ... In a travel X0, X1, .., Xi-1, Xi, Xi+1.., X0 you will suppose - to make it easier - that there is a right angle in Xi (i > 0).
//
//So if a town Xi is not visited you will consider that the triangle X0Xi-1Xi+1 is still a right triangle in Xi-1 and you can use the "Pythagorean_theorem".
fun tour(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {
    val map = mutableMapOf<String, Double>()
    val towns = mutableListOf<String>()

    //add town to route, if arrFriend contains respective friend
    for (subArray in ftwns) {
        if (arrFriends.contains(subArray[0])) {
            towns.add(subArray[1])
        }

    }
    //add towns and distances to new map
    for (s in towns) {
        map.put(s, h[s]!!)
    }


    //initial distance (to the first friend + from the last friend
    var sum = if (towns.size > 0) map[towns[0]]!! + map[towns[towns.size -1]]!! else return 0

    //calculate sum of distances using Pythagorean theorem
    for (i in 1 until map.size) {
            val hypotenuse = map[towns[i]]!!
            val leg = map[towns[i-1]]!!
            sum += Math.sqrt(Math.pow(hypotenuse, 2.0) - Math.pow(leg, 2.0))
    }
    return sum.toInt()
}

