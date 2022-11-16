package machine

val COFFEE_MACHINE = CoffeeMachine()
var MENU_CHOICE = ""

fun main() {
    display()
    menu()
//    startDisplay()
//    val cupOfCoffee = CupOfCoffee()
//    val qtyRequest = enterQuantity()
//
//    val makeCups = makeCupsOfCoffee(cupOfCoffee)
//
//    println(makeCups)
//
//    if (qtyRequest > makeCups) {
//        println("No, I can make only $makeCups cups of coffee")
//    } else {
//        print("Yes, I can make that amount of coffee")
//        if (qtyRequest < makeCups) {
//            print(" (and even ${makeCups - qtyRequest} more than that)")
//        }
//    }
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
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550
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

fun display() {
    println("The coffee machine has:\n" +
            "${COFFEE_MACHINE.water} ml of water\n" +
            "${COFFEE_MACHINE.milk} ml of milk\n" +
            "${COFFEE_MACHINE.coffee} g of coffee beans\n" +
            "${COFFEE_MACHINE.cups} disposable cups\n" +
            "$${COFFEE_MACHINE.money} of money"
    )
}
// Make menu
fun menu() {
    println("\nWrite action (buy, fill, take):")
    MENU_CHOICE = readln()
    when (MENU_CHOICE.toString()) {
        // Buy a coffee
        "buy" -> buy()
        // Load the coffee machine
        "fill" -> fill()
        // Pick up money
        "take" -> take()
    }
    display()
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    when (readln().toInt()) {
        1 -> println("espresso\n")
        2 -> println("latte\n")
        3 -> println("cappuccino\n")
    }
}

fun fill() {
    println("fun fill")
}

fun take() {
    println("fun take")
}




