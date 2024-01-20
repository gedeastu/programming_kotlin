package org.example

fun main() {
    var fullName = getFullName(first = "Gede", middle = "Astu", last = "Nugraha")
    println(fullName)
    val number = sumNumber("Astu Nugraha",10,20,30,40,50)
    print("${number}")
}
fun getFullName(first: String, middle: String, last: String):String{
    return "$first $middle $last"
}

//Vararg (Variable Argument)
fun sumNumber(name: String,vararg number:Int):String{
    return "$name ${number.sum()}"
}