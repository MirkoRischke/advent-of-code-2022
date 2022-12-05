package day3

class Rucksack {
    val firstCompartment = Compartment()
    val secondCompartment = Compartment()

    fun findDuplicatedItem(): Item {
        return firstCompartment.getUniqueItems()
            .intersect(secondCompartment.getUniqueItems())
            .first()
    }

    fun findUniqueItems(): Set<Item> {
        return firstCompartment.getUniqueItems()
            .plus(secondCompartment.getUniqueItems())
    }

    companion object {
        fun fromString(string: String): Rucksack {
            val firstHalf = string.substring(0, string.length / 2)
            val secondHalf = string.substring(string.length / 2)

            val rucksack = Rucksack()
            firstHalf.forEach {
                rucksack.firstCompartment.addItem(Item(it))
            }
            secondHalf.forEach {
                rucksack.secondCompartment.addItem(Item(it))
            }

            return rucksack
        }
    }
}
