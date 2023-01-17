package com.ddd_bootcamp.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CartTest {
    private val priceTest = Price(5.0)
    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val product = Product("Some test product", priceTest)
        cart.add(CartItem(2, product))
        val items = cart.items
        assertEquals(2, items.sumOf { it.quantity })
        assertEquals("Some test product", items[0].product.name)
    }

    @Test
    fun shouldRemoveProductFromCart() {
        val cart = Cart()
        val product = Product("Some test product", priceTest)
        cart.add(CartItem(2, product))

        cart.remove(product.name)
        val items = cart.items
        assertEquals(0, items.sumOf { it.quantity })
        assertEquals(1, cart.removedItems.size)
        assertEquals(listOf("Some test product"), cart.removedProductNames)
    }

    @Test
    fun `cart checkout should returns an order with cart products`() {
        val cart = Cart()
        val product = Product("Some test product", priceTest)
        cart.add(CartItem(2, product))

        val order = cart.checkOut()

        assertEquals(2, order.products.size)
        assertEquals(true, cart.checkedOut)
    }
}