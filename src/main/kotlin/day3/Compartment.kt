package day3

class Compartment {

    private val items: MutableSet<Item> = mutableSetOf()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun getUniqueItems(): Set<Item> {
        return items
    }


}
