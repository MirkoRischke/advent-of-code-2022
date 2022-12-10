package day4

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class AssignmentPairTest : DescribeSpec({

    describe("hasObsoleteAssignment") {
        it("returns false for non-overlapping assignments") {
            val assignmentPair = AssignmentPair(
                Assignment(1, 2),
                Assignment(3, 4)
            )

            val result = assignmentPair.hasObsoleteAssignment()

            result shouldBe false
        }

        it("returns false for assignments that overlap in some segments") {
            val assignmentPair = AssignmentPair(
                Assignment(1, 2),
                Assignment(2, 4)
            )

            val result = assignmentPair.hasObsoleteAssignment()

            result shouldBe false
        }

        it("returns true when the first assignment contains the second one") {
            val assignmentPair = AssignmentPair(
                Assignment(1, 3),
                Assignment(2, 3)
            )

            val result = assignmentPair.hasObsoleteAssignment()

            result shouldBe true
        }

        it("returns true when the second assignment contains the first one") {
            val assignmentPair = AssignmentPair(
                Assignment(2, 3),
                Assignment(1, 3)
            )

            val result = assignmentPair.hasObsoleteAssignment()

            result shouldBe true
        }
    }

    describe("fromString") {
        it("creates assignment pair from string") {
            val string = "2-3,0-4"

            val result = AssignmentPair.fromString(string)

            result shouldBe AssignmentPair(
                Assignment(2,3),
                Assignment(0,4),
            )
        }
    }

})
