package com.dojinyou.numble.timedeal.domain.product.dto

import java.time.Instant

data class CreateProductDto(
    val name: String,
    val price: Long,
    val stock: Long,
    val timeDealPrice: Long,
    val displayedAt: Instant,
    val openedAt: Instant,
    val closedAt: Instant,
)
