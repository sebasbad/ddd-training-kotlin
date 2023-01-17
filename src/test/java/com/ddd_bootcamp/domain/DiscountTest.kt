package com.ddd_bootcamp.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiscountTest {
    private val sut = Discount(0.1)

    @Test
    fun `discount should apply to price`() {
        val originalPrice = Price(100.0)

        val discountedPrice = sut.getDiscountedPrice(originalPrice)

        assertEquals(Price(90.0), discountedPrice)
    }
}