package com.thechance.myweather.presentation.uiModels.mapper

import com.thechance.myweather.presentation.uiModels.TimeTheme

fun Boolean.toTimeTheme(): TimeTheme {
    return when (this) {
        true -> TimeTheme.DAY
        false -> TimeTheme.NIGHT
    }
}