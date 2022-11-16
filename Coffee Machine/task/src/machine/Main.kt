package machine

val COFFEE_MACHINE = CoffeeMachine()
var MENU_CHOICE = ""

fun main() {
    display()
    menu()
}

// Make super class Cup, in future can create any drinks
open class CupOfCoffee() {
    open var water = 0
    open var milk = 0
    open var coffee = 0
    open var cost = 0
    var cup = 1
    open fun howManyCups(qty: Int = 0) {
        water *= qty
    }
}

// Make subclass tape of coffee, with ingredients to coffee
class Espresso() : CupOfCoffee() {
    override var water = 250
    override var milk = 0
    override var coffee = 16
    override var cost = 4
}

class Latte() : CupOfCoffee() {
    override var water = 350
    override var milk = 75
    override var coffee = 20
    override var cost = 7
}

class Cappuccino() : CupOfCoffee() {
    override var water = 200
    override var milk = 100
    override var coffee = 12
    override var cost = 6
}

class CoffeeMachine() {
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550
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
// Implementation request menu
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

// Function of sell coffee, balance calculation and update balances
fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    when (readln().toInt()) {
        1 -> {
            val cupOfEspresso = Espresso()
            COFFEE_MACHINE.water -= cupOfEspresso.water
            COFFEE_MACHINE.milk -= cupOfEspresso.milk
            COFFEE_MACHINE.coffee -= cupOfEspresso.coffee
            COFFEE_MACHINE.cups -= cupOfEspresso.cup
            COFFEE_MACHINE.money += cupOfEspresso.cost
        }
        2 -> {
            val cupOfLatte = Latte()
            COFFEE_MACHINE.water -= cupOfLatte.water
            COFFEE_MACHINE.milk -= cupOfLatte.milk
            COFFEE_MACHINE.coffee -= cupOfLatte.coffee
            COFFEE_MACHINE.cups -= cupOfLatte.cup
            COFFEE_MACHINE.money += cupOfLatte.cost
        }
        3 -> {
            val cupOfCappuccino = Cappuccino()
            COFFEE_MACHINE.water -= cupOfCappuccino.water
            COFFEE_MACHINE.milk -= cupOfCappuccino.milk
            COFFEE_MACHINE.coffee -= cupOfCappuccino.coffee
            COFFEE_MACHINE.cups -= cupOfCappuccino.cup
            COFFEE_MACHINE.money += cupOfCappuccino.cost
        }
    }
    println("")
}

// Function of
fun fill() {
    println("Write how many ml of water you want to add:")
    COFFEE_MACHINE.water += readln().toInt()

    println("Write how many ml of milk you want to add:")
    COFFEE_MACHINE.milk += readln().toInt()

    println("Write how many grams of coffee beans you want to add:")
    COFFEE_MACHINE.coffee += readln().toInt()

    println("Write how many disposable cups you want to add: ")
    COFFEE_MACHINE.cups += readln().toInt()
}

// Function collection of money and update balances
fun take() {
    println("I gave you $${COFFEE_MACHINE.money}\n")
    COFFEE_MACHINE.money = 0
}




