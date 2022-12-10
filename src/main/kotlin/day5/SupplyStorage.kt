package day5

class SupplyStorage(private val stacks: List<Stack>) {
    fun getStack(position: Int): Stack {
        return stacks[position - 1]
    }

    fun moveCrate(from: Int, to: Int) {
        val crate = getStack(from).removeCrate()

        getStack(to).addCrate(crate)
    }

    fun moveCrates(from: Int, to: Int, amount: Int) {
        repeat(amount) {
            moveCrate(from, to)
        }
    }

    companion object {
        fun fromDrawing(drawing: String): SupplyStorage {
            val lines = drawing.lines()
            val numberOfStacks = lines.last().split("   ").last().toInt()
            val stacks = List(numberOfStacks) { Stack() }
            val storage = SupplyStorage(stacks)

            lines.reversed().drop(1).forEach {
                addContainersFromLine(it, storage)
            }

            return storage
        }

        private fun addContainersFromLine(firstLine: String, storage: SupplyStorage) {
            firstLine.chunked(4).forEachIndexed { index, string ->
                val letterIndex = string.indexOf('[') + 1
                val crate = string[letterIndex]
                if (crate.isLetter()) {
                    storage.getStack(index + 1).addCrate(crate.toString())
                }
            }
        }
    }
}