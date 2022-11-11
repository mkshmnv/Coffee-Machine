package machine

fun main() {
    val cupsForParty = Cup(enterQuantity())
    cupsForParty.calculate()
    display(cupsForParty.qty, cupsForParty.water, cupsForParty.milk, cupsForParty.coffee)
}

class Cup(var qty: Int = 1) {
    var water = 200
    var milk = 50
    var coffee = 15

    fun calculate() {
        water *= qty
        milk *= qty
        coffee *= qty
    }
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


