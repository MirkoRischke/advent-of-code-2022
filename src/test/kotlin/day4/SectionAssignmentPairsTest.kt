package day4

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.spec.tempfile
import io.kotest.matchers.shouldBe

class SectionAssignmentPairsTest : DescribeSpec({

    describe("countObsoleteAssignmentPairs") {
        val obsoleteAssignmentPair = AssignmentPair(
            Assignment(1,3),
            Assignment(2,3),
        )

        val nonObsoleteAssignmentPair = AssignmentPair(
            Assignment(1,3),
            Assignment(4,5),
        )

        it("returns 0 for empty list") {
            val assignmentPairs = SectionAssignmentPairs(emptyList())

            val result = assignmentPairs.countObsoleteAssignmentPairs()

            result shouldBe 0
        }

        it("returns 0 for list of non-obsolete assigment pairs") {
            val assignmentPairs = SectionAssignmentPairs(listOf(
                nonObsoleteAssignmentPair,
                nonObsoleteAssignmentPair
            ))

            val result = assignmentPairs.countObsoleteAssignmentPairs()

            result shouldBe 0
        }

        it("returns amount of obsolete assignments") {
            val assignmentPairs = SectionAssignmentPairs(listOf(
                obsoleteAssignmentPair,
                nonObsoleteAssignmentPair,
                obsoleteAssignmentPair
            ))

            val result = assignmentPairs.countObsoleteAssignmentPairs()

            result shouldBe 2
        }
    }

    describe("fromPath") {
        it("creates assignment pairs from file") {
            val tempFile = tempfile()
            tempFile.writeText("""
                2-4,6-8
                2-3,4-5
                5-7,7-9
            """.trimIndent())

            val assignmentPairs = SectionAssignmentPairs.fromPath(tempFile.toPath())

            assignmentPairs shouldBe SectionAssignmentPairs(listOf(
                AssignmentPair(
                    Assignment(2,4),
                    Assignment(6,8),
                ),
                AssignmentPair(
                    Assignment(2,3),
                    Assignment(4,5),
                ),
                AssignmentPair(
                    Assignment(5,7),
                    Assignment(7,9),
                ),
            ))
        }
    }

})
