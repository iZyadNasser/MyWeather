package com.thechance.myweather.presentation.uiModels

import com.thechance.myweather.presentation.utils.UiImage
import com.thechance.myweather.presentation.utils.UiText

data class DailyWeather(
    val dayOfWeek: String,
    val temperatureCelsius: Double,
    val minTemperatureCelsius: Double,
    val maxTemperatureCelsius: Double,
    val weatherImage: UiImage,
    val weatherDescription: UiText,
)
