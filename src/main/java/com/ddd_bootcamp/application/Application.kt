package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.CartItem
import com.ddd_bootcamp.domain.Product

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val cart = Cart()
        val applePencil = CartItem(2, Product("Apple Pencil"))
        cart.add(applePencil)
        val headphone = CartItem(1, Product("Sony Wireless headphone"))
        cart.add(headphone)
        cart.remove(applePencil.product.name)
        println("Cart = $cart")
        val cartItems = cart.items.joinToString("\n\t") { it.toString() }
        val removedCartItems = cart.removedItems.joinToString("\n\t") { it.toString() }
        println("----------------------------------------")
        println("Cart Items = \n$cartItems")
        println("----------------------------------------")
        println("Removed Cart Items = \n$removedCartItems")
        println("----------------------------------------")
    }
}
