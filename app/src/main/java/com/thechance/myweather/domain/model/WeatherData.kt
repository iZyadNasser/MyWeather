package com.thechance.myweather.domain.model

data class WeatherData(
    val currentWeather: Weather,
    val next7DaysWeather: List<Weather>
)
