import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

@OptIn(ObsoleteCoroutinesApi::class)
@InternalCoroutinesApi
//When Use runBlocking
fun main(): Unit = runBlocking {

    //run launch
    launch {
        card(name = "Air Jordan", price = 2000000, quantity = 4)
    }
    launch {
        delay(500L)
        println("This is card right now")
    }
    println("So do you wanna pay?")
    delay(2000L)
    println('\n')


    //Called launch from coroutineScope{}
    runCompile()
    println("Done")


    //With async & await()
    val outcome = async { getOutcome(20000) }
    val income = async { getIncome(25000) }
    println("${outcome.await()} & ${income.await()}")
    println('\n')


    //Started or Called Job
    val card = launch(start = CoroutineStart.LAZY){
        card(name = "Immortality 3", price = 1900000, quantity = 3)
    }
    //use start() for output
    //card.start()

    //use join() for output
    //card.join()

    println("So What you gonna do?")

    //use cancel() for output
    delay(2000L)
    //with CancellationException() for reason why cancelled job
    card.cancel(CancellationException("Press back navigation"))
    println("Back to Home")
    if (card.isCancelled){
        // and we can get value of CancellationException() with getCancellationException()
        println("Thank you so much, \"You're ${card.getCancellationException().message}\" ")
    }
    println('\n')


    //Dispatcher
    //Dispatchers.Default
    println("Before launching coroutine: ${Thread.currentThread().name}")
    launch(Dispatchers.Default){
        // TODO: Implement suspending lambda here
        println("Inside coroutine: ${Thread.currentThread().name}")
    }
    println("After coroutine: ${Thread.currentThread().name}")

    //Dispatchers.IO
    launch(Dispatchers.IO) {
        println("Inside IO coroutine: ${Thread.currentThread().name}")
    }

    //Dispatchers.Unconfined
    launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()


    //Dispatcher depends on thread
    //newSingleThreadContext()
    val dispatcherNewSingleThreadContext = newSingleThreadContext("myThread")
    launch(dispatcherNewSingleThreadContext) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()

    //newFixedThreadPoolContext()
    val dispatchNewFixedThreadPoolContext = newFixedThreadPoolContext(3, "myPool")
    launch(dispatchNewFixedThreadPoolContext) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()


    //Channel, honestly I am not really understand about this topic
    runBlocking(CoroutineName("main")) {
        val channel = Channel<Int>()
        launch(CoroutineName("v1coroutine")){
            println("Sending from ${Thread.currentThread().name}")
            for (x in 1..5) channel.send(x * x)
        }

        repeat(5) { println(channel.receive()) }
        println("received in ${Thread.currentThread().name}")
    }
}

//When Use launch{} with use coroutineScope{}
suspend fun runCompile() = coroutineScope {
    launch {
        delay(500L)
        println("Run & Compile the Codes")
    }
    launch {
        delay(1000L)
        println("Debugger the Codes")
    }
    launch {
        delay(2000)
        println("Show the result")
    }
}


//suspend fun for async & await()
suspend fun getOutcome(outcome:Int):Int{
    delay(1000L)
    return outcome
}
suspend fun getIncome(income:Int):Int{
    delay(1000L)
    return income
}


//suspend fun for Job
suspend fun card(name:String,price:Int,quantity:Int){
        delay(1000L)
        println("$name with $price in $quantity")
}
