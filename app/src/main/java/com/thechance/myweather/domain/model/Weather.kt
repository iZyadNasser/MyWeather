package com.thechance.myweather.domain.model

import kotlinx.datetime.LocalDate

data class Weather(
    val temperatureCelsius: Double?,
    val feelsLikeTemperatureCelsius: Double?,
    val highesTemperatureCelsius: Double?,
    val lowestTemperatureCelsius: Double?,
    val weatherCode: Int?,
    val windSpeedKmPerHour: Double?,
    val relativeHumidityPercentage: Int?,
    val rainPrecipitationPercent: Int?,
    val pressureMslHPerA: Double?,
    val uvIndex: Double?,
    val day: LocalDate?
)