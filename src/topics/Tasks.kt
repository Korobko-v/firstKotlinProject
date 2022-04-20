package topics

fun main() {
    var array1 = intArrayOf(1, 2, 3, 0)
    var array2 = intArrayOf(5, 1, 2, 7, 3, 2, 2, 2)

    println(getRepeatedIntersection(array1, array2))
    println(groupWords(arrayOf("tea", "eat", "joppa")))
}

fun cross(list1: List<Any>, list2: List<Any>): List<Any> {
    var list22 = list2
    var list: MutableList<Any> = mutableListOf()
    for (item in list1) {
        if (list22.contains(item)) {
            list.add(item)
            list22 -= item
        }
     }
    return list
}

fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {
   val s1 = a1.toHashSet()
   val s2 = a2.toHashSet()

    val result = mutableListOf<Int>()
    for (item in s1) {
        if (s2.contains(item)) {
            val numOfRepeats = minOf(a1.count {it == item}, a2.count {it == item})
            repeat(numOfRepeats) { result.add(item) }
        }
    }
    return result
}

fun groupWords(words: Array<String>): List<List<String>> {

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
    if (map.containsKey(sortedWord)) {
        map[sortedWord]?.add(word)
    }
        else
            map[sortedWord] = mutableListOf(word)
    }

    return map.values.toList()
}