package com.thechance.myweather.presentation.utils

fun String.formatCityName(): String {
    return if (this.contains(" city", ignoreCase = true)) {
        this.removeSuffix(" city")
            .removeSuffix(" City")
    } else {
        this
    }
}