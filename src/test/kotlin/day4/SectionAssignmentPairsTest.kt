package day4

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.spec.tempfile
import io.kotest.matchers.shouldBe

class SectionAssignmentPairsTest : DescribeSpec({

    val obsoleteAssignmentPair = AssignmentPair(
        Assignment(1, 3),
        Assignment(2, 3),
    )

    val partlyOverlappingAssignmentPair = AssignmentPair(
        Assignment(1, 3),
        Assignment(3, 4),
    )

    val distinctAssignmentPair = AssignmentPair(
        Assignment(1, 3),
        Assignment(4, 5),
    )


    describe("countObsoleteAssignmentPairs") {
        it("returns 0 for empty list") {
            val assignmentPairs = SectionAssignmentPairs(emptyList())

            val result = assignmentPairs.countObsoleteAssignmentPairs()

            result shouldBe 0
        }

        it("returns 0 for list of non-obsolete assigment pairs") {
            val assignmentPairs = SectionAssignmentPairs(
                listOf(
                    partlyOverlappingAssignmentPair,
                    partlyOverlappingAssignmentPair
                )
            )

            val result = assignmentPairs.countObsoleteAssignmentPairs()

            result shouldBe 0
        }

        it("returns amount of obsolete assignments") {
            val assignmentPairs = SectionAssignmentPairs(
                listOf(
                    obsoleteAssignmentPair,
                    partlyOverlappingAssignmentPair,
                    obsoleteAssignmentPair
                )
            )

            val result = assignmentPairs.countObsoleteAssignmentPairs()

            result shouldBe 2
        }
    }

    describe("countOverlappingAssignmentPairs") {
        it("returns 0 when there are no overlapping assignment pairs") {
            val assignmentPairs = SectionAssignmentPairs(
                listOf(
                    distinctAssignmentPair,
                    distinctAssignmentPair,
                )
            )

            val result = assignmentPairs.countOverlappingAssignmentPairs()

            result shouldBe 0
        }

        it("returns number of overlapping pairs") {
            val assignmentPairs = SectionAssignmentPairs(
                listOf(
                    distinctAssignmentPair,
                    partlyOverlappingAssignmentPair,
                    obsoleteAssignmentPair,
                )
            )

            val result = assignmentPairs.countOverlappingAssignmentPairs()

            result shouldBe 2
        }
    }

    describe("fromPath") {
        it("creates assignment pairs from file") {
            val tempFile = tempfile()
            tempFile.writeText(
                """
                2-4,6-8
                2-3,4-5
                5-7,7-9
            """.trimIndent()
            )

            val assignmentPairs = SectionAssignmentPairs.fromPath(tempFile.toPath())

            assignmentPairs shouldBe SectionAssignmentPairs(
                listOf(
                    AssignmentPair(
                        Assignment(2, 4),
                        Assignment(6, 8),
                    ),
                    AssignmentPair(
                        Assignment(2, 3),
                        Assignment(4, 5),
                    ),
                    AssignmentPair(
                        Assignment(5, 7),
                        Assignment(7, 9),
                    ),
                )
            )
        }
    }

})
