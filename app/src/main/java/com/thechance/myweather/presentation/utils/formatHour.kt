package com.thechance.myweather.presentation.utils

fun String.formatHour(): String {
    return if (this.length == 2) {
        "$this:00"
    } else {
        "0$this:00"
    }
}

fun Int.to12HourFormat(): Int {
    return if (this > 12) {
        this - 12
    } else {
        this
    }
}