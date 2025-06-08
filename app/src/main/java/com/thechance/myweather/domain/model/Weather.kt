package com.thechance.myweather.domain.model

data class Weather(
    val temperatureCelsius: Double,
    val feelsLikeTemperatureCelsius: Double,
    val highestTemperatureCelsius: Double,
    val lowestTemperatureCelsius: Double,
    val weatherStatus: String,
    val windSpeedKmPerHour: Double,
    val humidityPercentage: Double,
    val rainChancePercentage: Double,
    val uvIndex: Double,
    val pressureHPerA: Double,
)