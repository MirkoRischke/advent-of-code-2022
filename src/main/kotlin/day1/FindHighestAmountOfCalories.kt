package day1

class FindHighestAmountOfCalories {
    fun getCalories(elves: List<Elf>): Int {
        if(elves.isEmpty()) {
            throw Error("Empty List is not allowed")
        }
        return elves.maxOf { it.getTotalCalories() }
    }
}