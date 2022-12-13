package day2.strategy

import java.nio.file.Path

data class StrategyGuideV2(private val strategies: List<StrategyV2>) : StrategyGuide(strategies) {

    companion object {
        fun fromPath(path: Path): StrategyGuideV2 {
            return fromPath(
                path,
                { column1, column2 -> StrategyV2(column1, column2) },
                { strategies -> StrategyGuideV2(strategies) }
            )
        }
    }
}
