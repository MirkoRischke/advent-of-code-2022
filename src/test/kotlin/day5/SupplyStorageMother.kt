package day5

object SupplyStorageMother {

    fun aSupplyStorage(
        stacks: List<Stack> = emptyList(),
        crane: Crane = CrateMover9000()
    ): SupplyStorage = SupplyStorage(
        stacks = stacks,
        crane = crane,
    )
}
