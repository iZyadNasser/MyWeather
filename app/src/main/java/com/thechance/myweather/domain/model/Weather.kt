package com.thechance.myweather.domain.model

import kotlinx.datetime.LocalDateTime

data class Weather(
    val temperatureCelsius: Double,
    val feelsLikeTemperatureCelsius: Double,
    val weatherStatus: WeatherStatus,
    val windSpeedKmPerHour: Double,
    val relativeHumidityPercentage: Int,
    val rainPrecipitationPercent: Int,
    val pressureMslHPerA: Double,
    val uvIndex: Double,
    val time: LocalDateTime,
    val isDay: Boolean
)