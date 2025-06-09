package com.thechance.myweather.presentation.uiModels

import com.thechance.myweather.presentation.utils.UiImage
import com.thechance.myweather.presentation.utils.UiText
import kotlinx.datetime.LocalDateTime

data class CurrentWeather(
    val temperatureCelsius: Double,
    val feelsLikeTemperatureCelsius: Double,
    val minTemperatureCelsius: Double,
    val maxTemperatureCelsius: Double,
    val weatherImage: UiImage,
    val weatherDescription: UiText,
    val windSpeedKmPerHour: Double,
    val relativeHumidityPercentage: Int,
    val rainPrecipitationPercent: Int,
    val pressureMslHPerA: Double,
    val uvIndex: Double,
    val time: LocalDateTime,
    val isDay: Boolean
)
