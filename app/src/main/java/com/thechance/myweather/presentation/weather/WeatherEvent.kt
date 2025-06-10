package com.thechance.myweather.presentation.weather

import com.thechance.myweather.presentation.utils.UiText

sealed interface WeatherEvent {
    data class HandleError(val message: UiText) : WeatherEvent
}