package astu

fun main() {
    //Intro Generics
    val points = mapOf<String, Int>(
        "alfian" to 10 ,
        "dimas" to 20
    )
    println(points["alfian"])


    //Declared Generic Class
    val intBox: Container<Int> = Box(10)
    val stringBox:Container<String> = Box("Hello this is Astu")
    println(stringBox.getValue())
    println(intBox.getValue())


    //Declared Generic Function
    val intPair = createPair(10, 20)
    println("Int Pair: $intPair")
    val stringPair = createPair("Hello", "World")
    println("String Pair: $stringPair")


    //Constraint Type Parameter Called
    val ListName = ListName<Int>()
    println(ListName.get(3))


    //Variance Called
    //Covariant (Producer)
    val superheroes: Superheroes<String> = Superheroes("Batman")
    val anySuperheroes: Superheroes<Any> = superheroes
    println(anySuperheroes.getValue())
    //Contravariant (Consumer)
    val anyConsumer: Consumer<Any> = Consumer("")
    val stringConsumer: Consumer<String> = anyConsumer // Contravariance allows assigning ConsumerBox<Any> to ConsumerBox<String>
    stringConsumer.setValue("Hello, generics!") // This is valid because stringConsumerBox is a ConsumerBox<String>
    println("Value in anyConsumer: ${anyConsumer.getValue()}") // Output: Value in anyConsumerBox: Hello, generics!
}


//Make Generic Class
interface Container<T>{
    fun getValue():T
}
class Box<T>(private val value: T):Container<T>{
    override fun getValue(): T {
        return value
    }
}


//Make Generic Function
public fun <T> createPair(first:T,second:T):Pair<T,T>{
    return Pair(first,second)
}


//Make Constraint Type Parameter
interface List<T : Number>{
    fun get(index: T):T
}
class ListName<T : Number> : List<T>{
    override fun get(index: T): T {
        return index
    }
}

//Make Variance
//Covariant (Producer)
class Superheroes<out T>(private val name: T){
    fun getValue():T{
        return name
    }
}
//Contravariant (Consumer)
class Consumer<in T>(private var value: T){
    fun setValue(newValue:T){
        value = newValue
    }

    fun getValue(): @UnsafeVariance T{
        return value
    }
}

