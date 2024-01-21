package org.example

import javax.xml.crypto.dsig.Reference
import kotlin.random.Random

data class Item(val key:String, val value: Any)

fun main(args: Array<String>) {
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


    WithParameterMessage("Hello And Welcome")


    printResult(10){ value ->
        value + value
    }
    printResult(20){ value ->
        value + value
    }


    val message = buildString {
        append("Hello ")
        append(" Astu ")
        append("Welcome")
    }
    println(message)

    //Context Object
    //Lambda receiver
    val helloString = StringBuilder().apply {
        append("Hello ")
        append("Astu")
    }
    println(helloString)
    //Lambda argument
    val text = "hello"
    text.let { value ->
        val message = "$value kotlin!"
        println(message)
    }


    //Scope Function with Lambda Receiver
    val textHello = "Hello"
    //Run
    val result = textHello.run{
        val from = this
        val to = this.replace("Hello","Kotlin")
        "replace text from $from to $to"
    }
    println("result : $result")
    //With
    val resultWith = with(textHello){
        println("value is $this")
        println("with length ${this.length}")
    }
    //Apply
    val messageApply = StringBuilder().apply {
        append("Hello ")
        append("Kotlin!")
    }
    println(messageApply.toString())

    //Scope Function with Lambda Argument
    //Let
    val nameLet:String? = null
    nameLet?.let {
        val length = it.length * 2
        val text = "my name length is $length"
        println(text)
    } ?: run {
        val text = "message is null"
        println(text)
    }
    //Also
    val nameAlso = "Gede Astu"
    val resultAlso = nameAlso.also {
        println("value length -> ${it.length}")
    }
    println("text -> $resultAlso")

    count(10,20)

    //Called Function Reference
    val numbers = 1.rangeTo(10)
    val evenNumbers = numbers.filter(Int::isEvenNumber)
    println(evenNumbers)

    //Property References
    println(::messageKotlin.name)
    println(::messageKotlin.get())
    ::messageKotlin.set("Dart FLutter")
    println(::messageKotlin.get())

    //Immutable Property References
    println(::messageKotlin.name)
    println(::messageKotlin.get())
    // ::messageKotlin.set("Dart FLutter")
    println(::messageKotlin.get())

    funInsideFun(10,10,10)

    funInsideFunExtensions(10,10,10)

    //Fold and FoldRight
    //1. Fold
    val numbersFold = listOf(1, 2, 3)
    val fold = numbersFold.fold(10) { current, item ->
        println("current $current")
        println("item $item")
        println()
        current + item
    }
    println("Fold result: $fold")
    //2. FoldRight
    val numbersFoldRight = listOf(1, 2, 3)
    val foldRightVer = numbersFoldRight.foldRight(10) { item, current ->
        println("current $current")
        println("item $item")
        println()
        item + current
    }
    println("Fold result: $foldRightVer")

    //Drop and DropLast
    //1. Drop
    val numberDrop = listOf(1, 2, 3, 4, 5, 6)
    val drop = numberDrop.drop(3)
    println(drop)
    //2. DropLast
    val numberDropLast = listOf(1, 2, 3, 4, 5, 6)
    val dropLastVer = numberDropLast.dropLast(3)
    println(dropLastVer)

    //Take and TakeLast
    //1. Take
    val totalTake = listOf(1, 2, 3, 4, 5, 6)
    val take = totalTake.take(3)
    println(take)
    //2. TakeLast
    val totalTakeLast = listOf(1, 2, 3, 4, 5, 6)
    val takeLastVer = totalTakeLast.takeLast(3)
    println(takeLastVer)

    //Slice and Step
    //1. Slice
    val totalSlice = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val slice = totalSlice.slice(3..6)
    println(slice)
    //2. Step
    val totalStep = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val step = totalStep.slice(3..6 step 2)
    println(step)

    //Distinct and DistinctBy
    //1. Distinct
    val totalDistinct = listOf(1, 2, 1, 3, 4, 5, 2, 3, 4, 5)
    val distinct = totalDistinct.distinct()
    println(distinct)
    //2. DistinctBy
    val textList = listOf("A", "B", "CC", "DD", "EEE", "F", "GGGG")
    val distinctBy = textList.distinctBy {
        it.length
    }
    println(distinctBy)

    //Distinct with Collection data class
    val items = listOf(
        Item("1", "Kotlin"),
        Item("2", "is"),
        Item("3", "Awesome"),
        Item("3", "as"),
        Item("3", "Programming"),
        Item("3", "Language")
    )
    val distinctItems = items.distinctBy { it.key }
    distinctItems.forEach {
        println("${it.key} with value ${it.value}")
    }

    //Chunked
    //part 1
    val wordPart1 = "QWERTY"
    val chunked = wordPart1.chunked(3)
    println(chunked)
    //part 2
    val wordPart2 = "QWERTY"
    val chunkedTransform = wordPart2.chunked(3) {
        it.toString().toLowerCase()
    }
    println(chunkedTransform)

    println("Factorial 9999 is: ${factorial(9999)}")
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

//Lambda
//without parameter
val WithoutParameterMessage = {
    println("Welcome and Enjoy your process")
}
//with parameter
val WithParameterMessage = {
   message: String -> println(message)
}

//High Order Function
//Basic
fun printResultBasic(value: Int, sum: (Int) -> Int) {
    val result = sum(value)
    println(result)
}
//Inline High Order Function
inline fun printResult(value: Int, sum: (Int) -> Int) {
    val result = sum(value)
    println(result)
}

//Lambda with Receiver
fun buildString(action: StringBuilder.()-> Unit):String{
    val stringBuilder = StringBuilder()
    stringBuilder.action()
    return stringBuilder.toString()
}

//Member References
val sum: (Int, Int) -> Int = ::count
fun count(valueA: Int, valueB
: Int): Int {
    return valueA + valueB
}

//Function References
fun Int.isEvenNumber() = this % 2 == 0

//Properties References
var messageKotlin = "Kotlin"

//Function Inside Function
fun funInsideFun(valueA: Int, valueB: Int, valueC: Int): Int {
    fun validateNumber(value: Int) {
        if (value == 0) {
            throw IllegalArgumentException("value must be better than 0")
        }
    }

    validateNumber(valueA)
    validateNumber(valueB)
    validateNumber(valueC)

    return valueA + valueB + valueC
}

//Function Inside Function with Extensions Function
fun funInsideFunExtensions(valueA: Int, valueB: Int, valueC: Int): Int {
    fun Int.validateNumber(){
        if (this == 0) {
            throw IllegalArgumentException("value must be better than 0")
        }
    }

    valueA.validateNumber()
    valueB.validateNumber()
    valueC.validateNumber()

    return valueA + valueB + valueC
}

//Recursion Function
fun factorial(n: Int): Int {
    return if (n == 1) {
        n
    } else {
        n * factorial(n - 1)
    }
}

//Tail Call Recursion Function
tailrec fun factorial(n: Int, result: Int = 1): Int {
    val newResult = n * result
    return if (n == 1) {
        newResult
    } else {
        factorial(n - 1, newResult)
    }
}


