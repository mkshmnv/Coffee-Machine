package machine

val COFFEE_MACHINE = CoffeeMachine()

fun main() {
    startDisplay()
    val cupOfCoffee = CupOfCoffee()
    val qtyRequest = enterQuantity()

    val makeCups = makeCupsOfCoffee(cupOfCoffee)

    println(makeCups)

    if (qtyRequest > makeCups) {
        println("No, I can make only $makeCups cups of coffee")
    } else {
        print("Yes, I can make that amount of coffee")
        if (qtyRequest < makeCups) {
            print(" (and even ${makeCups - qtyRequest} more than that)")
        }
    }
}

// Make super class Cup, in future can create any drinks
open class Cup() {
    open var water = 0

    open fun howManyCups(qty: Int = 0) {
        water *= qty
    }
}

// Make subclass coffee cup,
// with ingredients to coffee
// and calculate how many ingredients needed to any quantity's cups
class CupOfCoffee() : Cup() {
    override var water = 200
    var milk = 50
    var coffee = 15
    override fun howManyCups(qty: Int) {
        water *= qty
        milk *= qty
        coffee *= qty
    }
}

// Calculate how many cups can make
fun makeCupsOfCoffee(cup: CupOfCoffee): Int {
    var cups = 0
    while (COFFEE_MACHINE.water > cup.water &&
        COFFEE_MACHINE.milk > cup.milk &&
        COFFEE_MACHINE.coffee > cup.coffee) {
        cups += 1
        COFFEE_MACHINE.water -= cup.water
        COFFEE_MACHINE.milk -= cup.milk
        COFFEE_MACHINE.coffee -= cup.coffee
    }
    return cups
}

class CoffeeMachine() {
    var water = 0
    var milk = 0
    var coffee = 0
}

fun startDisplay() {
    println("Write how many ml of water the coffee machine has:")
    COFFEE_MACHINE.water = readln().toInt()

    println("Write how many ml of milk the coffee machine has:")
    COFFEE_MACHINE.milk = readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    COFFEE_MACHINE.coffee = readln().toInt()
}

fun enterQuantity() : Int {
    println("Write how many cups of coffee you will need:")
    return readln().toInt()
}

fun display(cups: Int, water: Int, milk: Int, coffee: Int) {
    println("For $cups cups of coffee you will need:\n" +
    "$water ml of water\n" +
    "$milk ml of milk\n" +
    "$coffee g of coffee beans"
    )
}


