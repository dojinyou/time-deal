package com.dojinyou.numble.timedeal.global.utils

import java.time.Clock
import java.time.Instant

object TimeUtils {
    private var clock: Clock? = null
    private val utcClock = Clock.systemUTC()

    fun now(): Instant {
        return (clock ?: utcClock).instant()
    }
}
