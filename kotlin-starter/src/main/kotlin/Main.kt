package org.example

import java.lang.Integer.sum
import java.sql.Statement

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Char
    var vocal:Char = 'A'
    println(vocal++)
    println(vocal++)
    println(vocal++)
    println(vocal++)
    println(vocal++)
    println(vocal--)
    println(vocal--)
    println(vocal--)

    //String
    var myName:String = "Gede Astu Nugraha"
    for (charMyName in myName){
        print(charMyName)
    }
    println('\n')
    val firstName = "${myName[0]}${myName[1]}${myName[2]}${myName[3]}"
    println(firstName)

    //Escaped String
    var helloMeaning:String = "Hello in indonesia is \"Hai\""
    println(helloMeaning)

    //Raw String
    val nameList = """
        Astu
        Puspitayani
        Gede
        Nyoman
    """.trimIndent()
    println(nameList)

    //Function
    fun myIdentity(name: String, age:Int):String{
        return "Hello, my name is $name, and my age is $age"
    }
    println(myIdentity("Gede Astu Nugraha",19))

    fun myGirlfriend(name: String, age:Int):Unit{
        println("\"Hello, my girlfriend is $name, and her age is $age\"")
    }
    myGirlfriend("Puspitayani",19)

    //If Expressions
    val openHours = 7
    val recent = 7
    val office: String
    office = if (recent > 7) {
        "Office already open"
    } else if (recent == openHours){
        "Wait a minute, office will be open"
    } else {
        "Office is closed"
    }
    println(office)

    //Boolean
    //Conjunction atau AND(&&)
    val officeOpen = 7
    val officeClosed = 16
    val now = 20

    val isOpen = now >= officeOpen && now <= officeClosed

    println("Office is open : $isOpen")

    //Disjuntion atau  OR(||)
    val isClose = now < officeOpen || now > officeClosed
    println("Office is closed : $isClose")

    //Negation atau NOT (!)
    if (!isOpen) {
        println("Office is closed")
    } else {
        println("Office is open")
    }


    //Array
    val intArray = intArrayOf(1, 3, 5, 7)  // [1, 3, 5, 7]
    intArray[2] = 11                       // [1, 3, 11, 7]
    println(intArray[2])

    //Nullable
    val textNull: String? = null

    //val textLength = text.length  // compile time error

    if (textNull != null){
        val textLength = textNull.length
        println(textLength)// ready to go
    }else{
        val textLength = textNull?.length
        println(textLength)// ready to go
    }

    //Safe Calls dan Elvis Operator
    val text: String? = null
    //Safe calls operator (?.)
    text?.length

    //Elvis Operator (?:)
    val textLength = text?.length ?: 7

    //Variables and data types var and val
    val sapa:String = "Hello"
    val name:String = "Kotlin"
    val since:Int = 2017
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    //String Template
    println("$sapa, $name! since $since")
    val required:String = "${if (name == "Kotlin") "welcome" else "who are you?" }"
    println(required)


    //Enumeration
    val colorRed = Color.RED
    val colorGreen = Color.GREEN
    val colorBlue = Color.BLUE
    println("${colorRed}${colorGreen}${colorBlue}")

    val enumColors: Array<Color> = enumValues()
    enumColors.forEach {color ->  
        println(color.value)
    }

    val colors: Array<Color> = Color.values()
    colors.forEach {color ->
        println("${color.ordinal}.${color.value}")
    }

    val findColor:Color = Color.GREEN
    when (findColor){
        Color.RED -> println("Color is Red")
        Color.BLUE -> println("Color is Blue")
        Color.GREEN -> println("Color is Green")
    }


    //Expressions dan Statements
    //Statements
    var timeNow = 7
    var openOffice = 6
    if (timeNow > openOffice) {
        println("Office already open")
    } else {
        println("Office close")
    }
    fun sumStatements() {
        val value1 = 10
        val value2 = 10

        sum(value1, value2)
    }
    fun sumStatements(value1: Int, value2: Int) = value1 + value2


    //Expressions
    fun sumExpressions() {
        sum(1 , 1 * 4)
    }
    fun sumExpressions(value1: Int, value2: Int) = value1 + value2
    val officeExpressions = if (now > openOffice) "Office already open" else "Office close"
    print(officeExpressions)

    //When Expressions
    val value = 7
    val stringOfValue = when (value) {
        6 -> {
            println("Six")
            "value is 6"
        }
        7 -> {
            println("Seven")
            "value is 7"
        }
        8 -> {
            println("Eight")
            "value is 8"
        }
        else -> {
            println("undefined")
            "value cannot be reached"
        }
    }
    //with is
    val anyType : Any = 100L
    when(anyType){
        is Long -> println("the value has a Long type")
        is String -> println("the value has a String type")
        else -> println("undefined")
    }
    //with in
    val valueRanges =  27
    val ranges = 10..50
    when(valueRanges){
        in ranges -> println("value is in the range")
        !in ranges -> println("value is outside the range")
    }


    println(stringOfValue)
//    for (i in 1..5) {
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        println("i = $i")
//    }
}

//Enumeration
enum class Color(val value: String){
    RED("0xFF0000"){
        fun printValue(){
            println("value of RED is $value")
        }},
    GREEN("0x00FF00"){
        fun printValue(){
            println("value of GREEN is $value")
        }},
    BLUE("0x0000FF"){
        fun printValue(){
            println("value of BLUE is $value")
        }}
}