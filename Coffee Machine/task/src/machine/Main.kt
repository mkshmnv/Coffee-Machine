package machine

val COFFEE_MACHINE = CoffeeMachine()

fun main() {
    startDisplay()
    val cupOfCoffee = Cup()

    val cups = enterQuantity()

    if (COFFEE_MACHINE.water < cupOfCoffee.water &&
        COFFEE_MACHINE.milk < cupOfCoffee.milk &&
        COFFEE_MACHINE.coffee < cupOfCoffee.coffee) {
        println("No, I can make only __0enter number of cups__ cups of coffee")
    } else if (COFFEE_MACHINE.water >= cupOfCoffee.water &&
        COFFEE_MACHINE.milk >= cupOfCoffee.milk &&
        COFFEE_MACHINE.coffee >= cupOfCoffee.coffee ) {
        print("Yes, I can make that amount of coffee")

        if (COFFEE_MACHINE.water >= cupOfCoffee.water * 2 &&
            COFFEE_MACHINE.milk >= cupOfCoffee.milk  * 2 &&
            COFFEE_MACHINE.coffee >= cupOfCoffee.coffee * 2) {
            print(" (and even N more than that)")
        }

    }

    canMakeAmountCoffee()
//    val cupsForParty = Cup()
//    cupsForParty.calculate(cups)
//    display(cupsForParty.qty, cupsForParty.water, cupsForParty.milk, cupsForParty.coffee)
}

class Cup() {
    var water = 200
    var milk = 50
    var coffee = 15

    fun calculate(qty: Int = 1) {
        water *= qty
        milk *= qty
        coffee *= qty
    }
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


