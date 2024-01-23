package astu

import kotlin.reflect.KProperty

fun main() {
    val somethingText = "Hello Astu!"
    somethingText.reversed().length
    val age = "19".toInt()
    println(age is Int)

    //Property Accessor
    val animal = Animal(name = "Gough", age = 19, weight = 20.0, isMamalia = true)
    animal.feet = 2
    animal.name = "Meow"
    println(animal.name)

    //Property Delegation Called
    animal.height = 3
    println(animal.height)

    //Extension Properties Called
    println(animal.getAnimalInfo)

    //Primary Constructor Called
    val car = Car("Ferrari","#FFFFF","Sport")
    println(car.pName)

    //Secondary Constructor
    val car2 = Car("Ferrari","#FFFFF","Sport",true)
    println(car2.pName)

    //Public Called
    Character(pNama = "Amy", pPower = 2000.00, pAge = 200, pActive = true)

    println(AsusTufGaming(pName = "Asus TUF Gaming A15", pColor = "White"))


    //Inheritances Called
    val samsung = Samsung(pName = "Samsung S22", pFurColor = "White", pType = "S22", pActivePeriod = true, from = "South Korea")
    println(samsung.name)

    //Overloading Called
    val calc = Calculator()
    println(calc.add(2, 4))
    println(calc.add(2.5, 2.2))
    println(calc.add(6f, 7f))
    println(calc.add(1, 2, 3))
    println(calc.min(9, 2))
    println(calc.min(17.2, 18.3))

    //Abstract Class Called
    val square = Square(name = "Square", sides = 4)
    println(square.printName())
    println(square.calculate())

    //Interfaces
    val fighter = Fighter(hit = 2000)
    println(fighter.uppercut(true))

    //Anonymous Class Called
    //Anonymous Class
    fighterWithPunch(object : IPunch{
        override val hit: Int
            get() = 2000

        override fun uppercut(triggerred: Boolean) {
            if (triggerred){
                println("hit is $hit")
            }else{
                println("hit is 0")
            }
        }

        override fun jab(triggerred: Boolean) {
            if (triggerred){
                println("hit is $hit")
            }else{
                println("hit is 0")
            }
        }

        override fun lowStrike(triggerred: Boolean) {
            if (triggerred){
                println("hit is $hit")
            }else{
                println("hit is 0")
            }
        }
    })

    //Exception Handling
    val someNullValue: String? = null
    lateinit var someMustNotNullValue: String
    try {
        someMustNotNullValue = someNullValue!!
        println(someMustNotNullValue)
    }catch (e: Exception){
        someMustNotNullValue = "Nilai String Null"
        println(someMustNotNullValue)
    }
    //with finally
    finally {
        println(someMustNotNullValue)
    }

    //Multiple Catch in Exception Handling
    val someStringValue: String? = null
    var someIntValue: Int = 0
    try {
        someIntValue = someStringValue!!.toInt()
    } catch (e: NullPointerException) {
        someIntValue = 0
    } catch (e: NumberFormatException) {
        someIntValue = -1
    } finally {
        when(someIntValue){
            0 -> println("Catch block NullPointerException terpanggil !")
            -1 -> println("Catch block NumberFormatException terpanggil !")
            else -> println(someIntValue)
        }
    }
}


//Interfaces
interface IPunch{
    val hit:Int
    fun uppercut(triggerred: Boolean)
    fun jab(triggerred: Boolean)
    fun lowStrike(triggerred: Boolean)
}
class Fighter(override val hit: Int) : IPunch{
    override fun uppercut(triggerred:Boolean) {
        if (triggerred){
            println("hit is $hit")
        }else{
            println("hit is 0")
        }
    }

    override fun jab(triggerred: Boolean) {
        if (triggerred){
            println("hit is $hit")
        }else{
            println("hit is 0")
        }
    }

    override fun lowStrike(triggerred: Boolean) {
        if (triggerred){
            println("hit is $hit")
        }else{
            println("hit is 0")
        }
    }

}
fun fighterWithPunch(fighter: IPunch){
    fighter.hit
}


//Abstract Class
abstract class Shape{
    //Abstract properties
    abstract val name:String
    abstract val sides:Int

    abstract fun calculate():Double

    fun printName(){
        println("The $name shape has $sides sides")
    }
}
class Square(override val name: String, override val sides: Int):Shape(){
    override fun calculate(): Double {
        return Math.PI * sides*sides
    }
}


//Overloading
class Calculator{
    fun add(value1: Int, value2: Int) = value1 + value2
    fun add(value1: Int, value2: Int, value3: Int) = value1 + value2 + value3
    fun add(value1: Double, value2: Double) = value1 + value2
    fun add(value1: Float, value2: Float) = value1 + value2
    fun min(value1: Int, value2: Int) = if (value1 < value2) value1 else value2
    fun min(value1: Double, value2: Double) = if (value1 < value2) value1 else value2
}


//Inheritaces
open class Handphones(val name: String, val furColor:String, val type: String, val activePeriod:Boolean ){
    open fun turnOn(){
        println("$name with $type, in period is $activePeriod is ON!")
    }

    open fun turnOff(){
        println("$name with $type, in period is $activePeriod is OFF!")
    }
}
class Samsung(pName: String,pFurColor:String,pType: String,pActivePeriod: Boolean,val from:String) : Handphones(pName,pFurColor,pType,pActivePeriod){
    fun loadingApps(){
        println("Loading...")
    }

    override fun turnOff() {
        super.turnOff()
        println("$name with $type, in period is $activePeriod is ON!")
    }

    override fun turnOn() {
        super.turnOn()
        println("$name with $type, in period is $activePeriod is OFF!")
    }
}


//Visibility Modifiers
//Internal
internal class Handphone(val name:String)

//Protected Modifier
open class Laptop(val name: String,protected val color: String)
class AsusTufGaming(pName:String,pColor: String):Laptop(pName,pColor)

//Public Modifier
public class Character(var pNama:String,var pPower:Double,var pAge:Int,var pActive:Boolean){

    //Private Modifier
    private var nama:String
    private var power:Double
    private var age:Int
    private var active:Boolean

    //This function can access and set the private value
    fun getNama():String{
        return pNama
    }
    fun setNama(value:String){
        pNama = value
    }

    init {
        this.nama = pNama
        this.power = pPower
        this.age = pAge
        this.active = pActive
    }
}


//Primary Constructor
class Car(var pName: String,var pColor:String, var pType:String){
    var name:String
    var color:String
    var type:String
    var status:Boolean

    init {
        this.name = pName
        this.color = pColor
        this.type = pType
        this.status = false
    }

    //Secondary Constructor
    constructor(name: String, color:String, type:String, status:Boolean) : this(name,color,type) {
        this.status = status
    }
}


//Property Delegation
class DelegateClass{
    private var value: Any = "Default"
    operator fun getValue(classRef:Any,property: KProperty<*>): Any{
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }
    operator  fun setValue(classRef: Any,property: KProperty<*>, newValue: Any){
        println("Nilai ${property.name} dari: $value akan berubah $newValue")
        value = newValue
    }
}


//Extension Properties
val Animal.getAnimalInfo : String
    get() = "Nama : ${this.name}, Berat: ${this.weight}, Mamalia: ${this.isMamalia}"


//Basic Class
class Animal(var name : Any, val weight: Double, val age: Int, val isMamalia: Boolean) {

    //Access variable by Delegate class
    var height : Any by DelegateClass()

    var feet:Int = 4
        //Getter & Setter
        get() {
            println("Fungsi Getter terpanggil")
            return field
        }set(value) {
            println("Fungsi Setter terpanggil")
            field = value
        }
    fun eat(){
        println("$name makan !")
    }
    fun sleep(){
        println("$name tidur !")
    }

}

