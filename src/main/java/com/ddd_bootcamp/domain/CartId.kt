package com.ddd_bootcamp.domain

import java.util.UUID

@JvmInline
value class CartId(val value: UUID = UUID.randomUUID())
