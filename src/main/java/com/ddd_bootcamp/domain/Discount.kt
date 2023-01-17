package com.ddd_bootcamp.domain

class Discount(
    private val discountPercentage: Double,
) {
    fun getDiscountedPrice(price: Price): Price =
        price.copy(quantity = price.quantity * (1.0 - discountPercentage))
}
