package day5

class CrateMover9001 : Crane {
    override fun moveCrates(from: Stack, to: Stack, amount: Int) {
        val crates = mutableListOf<Crate>()
        repeat(amount) {
            crates.add(0, from.removeCrate())
        }

        crates.forEach {
            to.addCrate(it)
        }
    }
}
