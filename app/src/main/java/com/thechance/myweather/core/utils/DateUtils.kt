package com.thechance.myweather.core.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getCurrentSystemDateTime(): LocalDateTime {
    val currentInstant = Clock.System.now()

    val currentZone = TimeZone.currentSystemDefault()

    return currentInstant.toLocalDateTime(currentZone)
}