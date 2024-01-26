package org.example

class User(val name:String,val age:Int){
    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }
}
data class DataUser(val name:String, val age: Int)
fun main() {
    val user =  User("Gede Astu", 19)
    val user2 =  User("astu", 19)
    val user3 =  User("Gede Astu", 19)
    val dataUser = DataUser("Puspitayani",19)
    val dataUser2 = DataUser("Nyoman",19)
    val dataUser3 = DataUser("Puspitayani",19)
    println(user == user3)
    println(dataUser.equals(dataUser3))

    //Menyalin dan Memodifikasi Data Class
    val dataUser4 = dataUser.copy(age = 20)
    println(dataUser4)

    //List
    val anyList = listOf('a', "Kotlin", 3, true, User("Gede Astu",19))
    println(anyList[2])

    //Mutable List
    val anyMutableList = mutableListOf('a', "Kotlin", 3, true, User("Puspitayani",19))
    anyMutableList.add('d') // menambah item di akhir list
    anyMutableList.add(1, "love") // menambah item pada indeks ke-1
    anyMutableList[3] = false // mengubah nilai item pada indeks ke-3
    anyMutableList.removeAt(0) // menghapus item pada indeks ke-0

    //Destructuring Declarations
    val dataSaya = DataUser("Gede Astu",19)
    val name = dataSaya.component1()
    val age = dataSaya.component2()
    println("My name is $name, at age $age")

    //Set
    val integerSet = setOf<Int>(1, 2, 4, 2, 1, 5)
    println(7 in integerSet)
    println(integerSet)
    val setC = setOf<Int>(1,5,7)
    val union = integerSet.union(setC)
    val intersect = integerSet.intersect(setC)
    println(union)
    println(intersect)

    //Mutable Set
    val mutableSet = mutableSetOf(1, 2, 4, 2, 1, 5)
    //mutableSet[2] = 6 // tidak bisa mengubah mutableSet
    mutableSet.add(6) // menambah item di akhir set
    mutableSet.remove(1) //menghapus item yang memiliki nilai 1

    //Map
    val city = mapOf(
        "Gianyar" to "Bali",
        "London" to "England",
        "Madrid" to "India"
    )
    val mapKeys = city.keys
    val mapValues = city.values
    println(mapKeys)
    println(city["Gianyar"])
    println(city.getValue("London"))

    //Mutable Map
    val mutableCapital = city.toMutableMap()
    mutableCapital.put("Amsterdam", "Netherlands")
    mutableCapital.put("Berlin", "Germany")


    //filter() dan filterNot()
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = numberList.filter { it % 2 == 0 }
    println(evenList)
    val notEvenList = numberList.filterNot { it % 2 == 0 }
    println(notEvenList)

    //map()
    val multipliedBy5 = numberList.map { it * 5 }
    println(multipliedBy5)

    //count()
    print(numberList.count())
    print(numberList.count { it % 3 == 0 })

    //find(), firstOrNull(), & lastOrNull()
    val firstOddNumber = numberList.find { it % 2 == 1 }
    val firstOrNullNumber = numberList.firstOrNull { it % 2 == 3 }

    //first() & last()
    val moreThan10 = numberList.first { it > 10 }
    print(moreThan10)

    //sum()
    val total = numberList.sum()
    // total: 55
    println(total)

    //sorted()
    val kotlinChar = listOf('k', 'o', 't', 'l', 'i', 'n')
    val ascendingSort = kotlinChar.sorted()
    println(ascendingSort)
    val descendingSort = kotlinChar.sortedDescending()
    println(descendingSort)

    //asSequence()
    val list = (1..1000000).toList()
    list.asSequence().filter { it % 5 == 0 }.map { it * 2 }.forEach { println(it) }

    //generateSequence()
    val sequenceNumber = generateSequence(1) { it + 1 }

    //take()
    sequenceNumber.take(5).forEach { print("$it ") }
}