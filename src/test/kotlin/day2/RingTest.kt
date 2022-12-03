package day2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import java.lang.IllegalArgumentException

class RingTest : DescribeSpec({

    describe("init") {
        it("fails when it is created with zero elements") {
            val error = shouldThrow<IllegalArgumentException> { Ring<Any>() }
            error.message shouldContain "At least one element is required"
        }
    }

    describe("getElementAfter") {
        it("returns the second item for the first item") {
            val first = "A"
            val second = "B"
            val ring = Ring(first, second)

            val result = ring.getElementAfter(first)

            result shouldBe second
        }

        it("returns the first item for the second item") {
            val first = "A"
            val second = "B"
            val ring = Ring(first, second)

            val result = ring.getElementAfter(second)

            result shouldBe first
        }

        it("returns the only existing element") {
            val first = "A"
            val ring = Ring(first)

            val result = ring.getElementAfter(first)

            result shouldBe first
        }

    }

    describe("getElementBefore") {
        it("returns the first item for the second item") {
            val first = "A"
            val second = "B"
            val ring = Ring(first, second)

            val result = ring.getElementBefore(second)

            result shouldBe first
        }

        it("returns the second item for the first item") {
            val first = "A"
            val second = "B"
            val ring = Ring(first, second)

            val result = ring.getElementBefore(first)

            result shouldBe second
        }

        it("returns the only existing element") {
            val first = "A"
            val ring = Ring(first)

            val result = ring.getElementBefore(first)

            result shouldBe first
        }
    }


})
