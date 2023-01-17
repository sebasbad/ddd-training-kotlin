package com.ddd_bootcamp.domain

import java.util.*

class Cart {
    val id = CartId()
    var checkedOut = false
    val cartItems: MutableList<CartItem> = ArrayList()
    private val removedCartItems: MutableList<CartItem> = ArrayList()

    fun add(cartItem: CartItem) {
        cartItems.add(cartItem)
    }

    fun remove(cartItemName: String) {
        cartItems.filter { it.product.name == cartItemName }.also {
            removedCartItems.addAll(it)
            cartItems.removeAll(it)
        }
    }

    val items: List<CartItem>
        get() = cartItems

    val removedItems: List<CartItem>
        get() = removedCartItems

    val removedProductNames get(): List<String> = removedItems.map { it.product.name }

    fun checkOut(): Order = cartItems.flatMap { cartItem ->
        buildList {
            for (i in 0 until cartItem.quantity) {
                add(cartItem.product)
            }
        }
    }.also {
        checkedOut = true
    }.let { products ->
        Order(products)
    }
    override fun toString(): String {
        return "Cart{" +
                "cartItems=" + cartItems +
                "; removedCartItems=" + removedCartItems +
                '}'
    }

    override fun equals(other: Any?): Boolean = other is Cart &&
            other.id == this.id

    override fun hashCode(): Int = Objects.hash(id, cartItems, removedItems)
}
