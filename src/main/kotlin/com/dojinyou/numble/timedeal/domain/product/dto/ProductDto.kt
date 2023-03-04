package com.dojinyou.numble.timedeal.domain.product.dto

import java.time.Instant
import java.util.UUID

data class ProductDto(
    val id: UUID,
    val name: String,
    val price: Long,
    val stock: Long,
    val timeDealPrice: Long,
    val displayedAt: Instant,
    val openedAt: Instant,
    val closedAt: Instant,
    val createdAt: Instant,
    val updatedAt: Instant
)
