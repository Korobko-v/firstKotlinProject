package topics

fun main() {
    var  child = Person("Child", "Child", 1)
    val p1 = Person("Tom", "Jones", 45, child)
    println(p1.firstName)

    var rectangle1 = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle1.perimeter}")
    println("The area is ${rectangle1.area()}")

    var rectangle2 = Rectangle(5.0, 2.0)
    println(rectangle2 == rectangle1)

}

//primary constructor
class Person(val firstName: String, val lastName: String, var age: Int) {
    var children: MutableList<Person> = mutableListOf() // ArrayList
    init {
        println("Person is created $firstName")
    }

    constructor(firstName: String, lastName: String, age: Int, child: Person): this(firstName, lastName, age) {
        children.add(child)
    }

    constructor(): this("", "", -1)
}

data class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2

    var test = 1
    get() = field + 1
    set(value) {
        if (value < 0) println("Negative value")
        field = value
    }

    fun area() = height * length

}