package org.example

import kotlin.random.Random

fun main() {
    var fullName = getFullName(first = "Gede", middle = "Astu", last = "Nugraha")
    println(fullName)

    val numberListArray = intArrayOf(10, 20, 30, 40)
    sets(numberListArray)

    val number = sumNumber("Astu Nugraha",10,20,*numberListArray,40,50,)
    println("${number}")

    Random.nextInt(1, 15).printInt()

    println(20.slice)

    val age:Int? = null
    println(age?.age)

    val sum : Arithmetic = {valueA,valueB -> valueA + valueB }
    val multiply : Arithmetic = {valueA,valueB -> valueA * valueB }

    val sumResult = sum?.invoke(10, 10)
    val multiplyResult = multiply?.invoke(20, 20)

    println(sumResult)
    println(multiplyResult)
}

//Basic Function
fun getFullName(first: String, middle: String, last: String):String{
    return "$first $middle $last"
}

//Vararg (Variable Argument)
fun sumNumber(name: String,vararg number:Int):String{
    return "$name ${number.sum()}"
}

//Array<T>
fun sets(number: IntArray):IntArray{
    return number
}

//Extensions
//Extensions Function
fun Int.printInt(){
    if (this < 10){
        println("the value is down of 10 = $this")
    }else if (this == this){
        println("the value is same of $this = $this")
    }else{
        println("the value is up of 10 = $this")
    }
}
//Extensions Properties
val Int.slice: Int
    get() = this / 2

//Nullable Receiver
val Int.age: Unit
    get() = if (this > 16){
        println("U can watch movie with R rated")
    }else{
        println("U can't watch movie with R rated")
    }

//Function Type
typealias Arithmetic = (Int, Int)->Int