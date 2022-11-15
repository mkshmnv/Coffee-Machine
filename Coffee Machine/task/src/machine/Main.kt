package machine

val COFFEE_MACHINE = CoffeeMachine()

fun main() {
    startDisplay()
    val cupOfCoffee = CupOfCoffee()
    cupOfCoffee.howManyCups(enterQuantity())
    println(cupsOfCoffee(cupOfCoffee))

//    if (COFFEE_MACHINE.water < cupOfCoffee.water &&
//        COFFEE_MACHINE.milk < cupOfCoffee.milk &&
//        COFFEE_MACHINE.coffee < cupOfCoffee.coffee) {
//        println("No, I can make only __0enter number of cups__ cups of coffee")
//    } else if (COFFEE_MACHINE.water >= cupOfCoffee.water &&
//        COFFEE_MACHINE.milk >= cupOfCoffee.milk &&
//        COFFEE_MACHINE.coffee >= cupOfCoffee.coffee ) {
//        print("Yes, I can make that amount of coffee")
//
//        if (COFFEE_MACHINE.water >= cupOfCoffee.water * 2 &&
//            COFFEE_MACHINE.milk >= cupOfCoffee.milk  * 2 &&
//            COFFEE_MACHINE.coffee >= cupOfCoffee.coffee * 2) {
//            print(" (and even N more than that)")
//        }
//
//    }

//    val cupsForParty = Cup()
//    cupsForParty.calculate(cups)
//    display(cupsForParty.qty, cupsForParty.water, cupsForParty.milk, cupsForParty.coffee)
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
fun cupsOfCoffee(cup: CupOfCoffee): Int = if ( COFFEE_MACHINE.water < cup.water &&
    COFFEE_MACHINE.milk < cup.milk &&
    COFFEE_MACHINE.coffee < cup.coffee ) {
    0
} else {
    val list = listOf(COFFEE_MACHINE.water / cup.water,
        COFFEE_MACHINE.milk / cup.milk,
        COFFEE_MACHINE.coffee / cup.coffee).sorted()
    list[0]
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


