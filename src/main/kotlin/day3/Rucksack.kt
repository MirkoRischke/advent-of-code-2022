package day3

class Rucksack {
    val firstCompartment = Compartment()
    val secondCompartment = Compartment()

    fun findDuplicatedItem(): Item {
        return firstCompartment.getUniqueItems()
            .intersect(secondCompartment.getUniqueItems())
            .first()
    }
}
