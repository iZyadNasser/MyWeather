package com.thechance.myweather.domain.model

import kotlinx.datetime.LocalDateTime

data class HourlyWeather(
    val temperatureCelsius: Double,
    val weatherCode: Int,
    val time: LocalDateTime
)
