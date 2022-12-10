package day4

import io.kotest.core.spec.style.DescribeSpec
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

})
