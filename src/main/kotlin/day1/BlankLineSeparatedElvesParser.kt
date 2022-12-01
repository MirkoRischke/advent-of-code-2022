package day1

class BlankLineSeparatedElvesParser : ElvesParser {
    override fun createElves(lines: Iterable<String>): Iterable<Elf> {
        val calorieSegments = caloriesSegments(lines)

        return calorieSegments.map { numbers ->
            Elf().apply {
                numbers.forEach { number ->
                    addFood(Food(number))
                }
            }
        }

    }

    private fun caloriesSegments(lines: Iterable<String>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        var currentList = mutableListOf<Int>()
        lines.forEachIndexed { index, line ->
            if (line.isNotBlank()) {
                currentList.add(line.toInt())
            } else if (index == 0) {
                return emptyList()
            } else {
                result.add(currentList)
                currentList = mutableListOf()
            }
        }

        result.add(currentList)
        return result
    }

}