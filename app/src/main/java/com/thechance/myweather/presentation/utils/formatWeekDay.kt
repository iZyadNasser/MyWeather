package com.thechance.myweather.presentation.utils

fun String.formatWeekDay(): String {
    return this.lowercase()
        .replaceFirstChar { it.uppercase() }
}