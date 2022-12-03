package day2.strategy

import java.nio.file.Path

data class StrategyGuideV1(private val strategies: List<StrategyV1>): StrategyGuide(strategies) {
    companion object {
        fun fromPath(path: Path): StrategyGuideV1 {
            return fromPath(
                path,
                {column1, column2 -> StrategyV1(column1, column2) },
                {strategies -> StrategyGuideV1(strategies) }
            )
        }
    }
}