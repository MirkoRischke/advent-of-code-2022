package day2.utils

class Ring<T>(private vararg val elements: T) {
    fun getElementAfter(element: T): T {
        val indexOfElement = elements.indexOf(element)
        return elements[(indexOfElement + 1).mod(elements.size)]
    }

    fun getElementBefore(element: T): T {
        val indexOfElement = elements.indexOf(element)
        return elements[(indexOfElement - 1).mod(elements.size)]
    }

    init {
        require(elements.isNotEmpty()) { "At least one element is required" }
    }
}
