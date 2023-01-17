package com.ddd_bootcamp.domain

import java.util.Currency

data class Price(
    val quantity: Double,
    val currency: Currency = Currency.getInstance("USD"),
)
