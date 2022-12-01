package day1

class FindElfWithMostCalories {
    fun getPosition(elves: List<Elf>): Int {
        if(elves.isEmpty()) {
            throw Error("Empty List is not allowed")
        }
        val maxIndex = elves.indices.maxBy { elves[it].getTotalCalories() }
        return maxIndex + 1
    }
}