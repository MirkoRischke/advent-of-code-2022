package day4

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class AssignmentTest : DescribeSpec({

    describe("contains") {
        it("returns true when they are the same") {
            val assignment1 = Assignment(1, 2)
            val assignment2 = assignment1.copy()

            val result = assignment1.contains(assignment2)

            result shouldBe true
        }

        it("returns true when the other smaller assignment is included in the assignment") {
            val assignment1 = Assignment(1, 4)
            val assignment2 = Assignment(2, 3)

            val result = assignment1.contains(assignment2)

            result shouldBe true
        }

        it("returns false when assignments share no sections") {
            val assignment1 = Assignment(1, 2)
            val assignment2 = Assignment(3, 4)

            val result = assignment1.contains(assignment2)

            result shouldBe false
        }

        it("returns false when assignments share only some sections") {
            val assignment1 = Assignment(1, 2)
            val assignment2 = Assignment(2, 3)

            val result = assignment1.contains(assignment2)

            result shouldBe false
        }
    }


})
