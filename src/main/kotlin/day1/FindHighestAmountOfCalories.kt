package day1

class FindHighestAmountOfCalories {
    fun getMaximumCalories(elves: List<Elf>): Int {
        if (elves.isEmpty()) {
            throw NoElvesPresent("Empty List is not allowed")
        }
        return elves.maxOf { it.getTotalCalories() }
    }

    fun getCaloriesOfRichestElves(elves: List<Elf>, numberOfRichestElvesToConsider: Int): Int {
        if (elves.isEmpty()) {
            throw NoElvesPresent("Empty List is not allowed")
        }
        return elves
            .map { it.getTotalCalories() }
            .sortedDescending()
            .take(numberOfRichestElvesToConsider)
            .sum()
    }
}

class NoElvesPresent(override val message: String?) : Exception()
