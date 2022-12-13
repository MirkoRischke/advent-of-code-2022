package day5

class CrateMover9000: Crane {
    override fun moveCrates(from: Stack, to: Stack, amount: Int) {
        repeat(amount) {
            val crate = from.removeCrate()
            to.addCrate(crate)
        }
    }
}