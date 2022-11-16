package machine

val COFFEE_MACHINE = CoffeeMachine()

fun main() = menu()

// Create main class with default resources
class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550
}

// Make super class Cup, in future can create any drinks
open class CupOfCoffee {
    open var water = 0
    open var milk = 0
    open var coffee = 0
    open var cost = 0
    var cup = 1
}

// Make a few subclasses type of coffee, with ingredients to coffee
class Espresso : CupOfCoffee() {
    override var water = 250
    override var milk = 0
    override var coffee = 16
    override var cost = 4
}

class Latte : CupOfCoffee() {
    override var water = 350
    override var milk = 75
    override var coffee = 20
    override var cost = 7
}

class Cappuccino : CupOfCoffee() {
    override var water = 200
    override var milk = 100
    override var coffee = 12
    override var cost = 6
}

// Output resources in coffee machine
fun remaining() {
    println("The coffee machine has:\n" +
            "${COFFEE_MACHINE.water} ml of water\n" +
            "${COFFEE_MACHINE.milk} ml of milk\n" +
            "${COFFEE_MACHINE.coffee} g of coffee beans\n" +
            "${COFFEE_MACHINE.cups} disposable cups\n" +
            "$${COFFEE_MACHINE.money} of money"
    )
}

// Menu coffee machine
fun menu() {
    println("Write action (buy, fill, take, remaining, exit):")

    when (readln()) {
        // Buy a coffee
        "buy" -> {
            println("")
            buy()
            println("")
            menu()
        }
        // Load resources the coffee machine
        "fill" -> {
            println("")
            fill()
            println("")
            menu()
        }
        // Pick up money
        "take" -> {
            take()
            menu()
        }
        // Pick up money
        "remaining" -> {
            println("")
            remaining()
            println("")
            menu()
        }
        // Pick up money
        "exit" -> {}
    }
}

// Function of checking resources in coffee machine
// sell coffee
// balance calculation
// update balances
fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
// Checking resources in coffee machine
    fun checkResources(cup: CupOfCoffee) {
        if (
            0 > COFFEE_MACHINE.water - cup.water ||
            0 > COFFEE_MACHINE.milk - cup.milk ||
            0 > COFFEE_MACHINE.coffee - cup.coffee ||
            0 > COFFEE_MACHINE.cups - cup.cup
        ) {
            if (0 > COFFEE_MACHINE.water - cup.water) println("Sorry, not enough water!")
            if (0 > COFFEE_MACHINE.milk - cup.milk) println("Sorry, not enough milk!")
            if (0 > COFFEE_MACHINE.coffee - cup.coffee) println("Sorry, not enough coffee!")
            if (0 > COFFEE_MACHINE.cups - cup.cup) println("Sorry, not enough cups!")
        } else {
            println("I have enough resources, making you a coffee!")
            COFFEE_MACHINE.water -= cup.water
            COFFEE_MACHINE.milk -= cup.milk
            COFFEE_MACHINE.coffee -= cup.coffee
            COFFEE_MACHINE.cups -= cup.cup
            COFFEE_MACHINE.money += cup.cost
        }
    }
// Submenu for buy a coffee
    when (readln()) {
        "1" -> {
            val cupOfEspresso = Espresso()
            checkResources(cupOfEspresso)
        }
        "2" -> {
            val cupOfLatte = Latte()
            checkResources(cupOfLatte)
        }
        "3" -> {
            val cupOfCappuccino = Cappuccino()
            checkResources(cupOfCappuccino)
        }
        "back" -> {}
    }
    println("")
}

// Function of upload resources in coffee machine
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

// Function encashment of money and update balances
fun take() {
    println("I gave you $${COFFEE_MACHINE.money}\n")
    COFFEE_MACHINE.money = 0
}






