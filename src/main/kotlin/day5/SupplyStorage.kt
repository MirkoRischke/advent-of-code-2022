package day5

private const val CHARS_UNTIL_NEXT_STACK = 4

class SupplyStorage(
    private val stacks: List<Stack>,
    private val crane: Crane
) {
    fun getStack(position: Int): Stack {
        return stacks[position - 1]
    }

    fun moveCrates(from: Int, to: Int, amount: Int) {
        crane.moveCrates(
            getStack(from),
            getStack(to),
            amount
        )
    }

    fun getTopCrates(): List<Crate> {
        return stacks.map { it.topCrate }
    }

    companion object {
        fun fromDrawing(drawing: List<String>, crane: Crane): SupplyStorage {
            val numberOfStacks = drawing.last().split("   ").last().toInt()
            val stacks = List(numberOfStacks) { Stack() }
            val storage = SupplyStorage(stacks, crane)

            drawing.reversed().drop(1).forEach {
                addContainersFromLine(it, storage)
            }

            return storage
        }

        private fun addContainersFromLine(firstLine: String, storage: SupplyStorage) {
            firstLine
                .chunked(CHARS_UNTIL_NEXT_STACK)
                .forEachIndexed { index, string ->
                    val letterIndex = string.indexOf('[') + 1
                    val crate = string[letterIndex]
                    if (crate.isLetter()) {
                        storage.getStack(index + 1).addCrate(crate.toString())
                    }
                }
        }
    }
}
