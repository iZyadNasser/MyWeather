package com.thechance.myweather.presentation.uiModels

import com.thechance.myweather.presentation.utils.UiImage
import com.thechance.myweather.presentation.utils.UiText

data class HourlyWeather(
    val hour: Int,
    val temperatureCelsius: Double,
    val weatherImage: UiImage,
    val weatherDescription: UiText,
)
