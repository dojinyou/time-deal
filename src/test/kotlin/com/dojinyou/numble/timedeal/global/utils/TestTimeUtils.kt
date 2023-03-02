package com.dojinyou.numble.timedeal.global.utils

import java.time.Clock

object TestTimeUtils {

    private val clock = TimeUtils.javaClass.getDeclaredField("clock").also {
        it.isAccessible = true
    }

    fun setClock(clock: Clock) {
        this.clock.set(TimeUtils, clock)
    }

    fun clear() {
        clock.set(TimeUtils, null)
    }
}
