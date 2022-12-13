package day1

class Elf {

    private val food: MutableList<Food> = mutableListOf()

    fun getTotalCalories(): Int {
        return food.sumOf { food -> food.calories }
    }

    fun addFood(food: Food) {
        this.food.add(food)
    }
}
