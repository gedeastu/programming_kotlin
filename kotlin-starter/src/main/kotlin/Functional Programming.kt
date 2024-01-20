package org.example

fun main() {
    var fullName = getFullName(first = "Gede", middle = "Astu", last = "Nugraha")
    println(fullName)
}
fun getFullName(first: String, middle: String, last: String):String{
    return "$first $middle $last"
}