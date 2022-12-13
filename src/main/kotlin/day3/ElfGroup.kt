package day3

class ElfGroup(rucksacks: List<Rucksack>) {
    val badge: Char

    init {
        badge = rucksacks
            .map { it.findUniqueItems() }
            .reduce { commonItems, nextItems ->
                commonItems.intersect(nextItems)
            }.first()
            .letter
    }
}
