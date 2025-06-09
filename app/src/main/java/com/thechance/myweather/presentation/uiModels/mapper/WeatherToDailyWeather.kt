package com.thechance.myweather.presentation.uiModels.mapper

import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.presentation.uiModels.DailyWeather

fun List<Weather>.toDailyWeather(): DailyWeather {
    return DailyWeather(
        dayOfWeek = this.first().time.dayOfWeek.name,
        temperatureCelsius = this.first().temperatureCelsius,
        minTemperatureCelsius = this.minOf { it.temperatureCelsius },
        maxTemperatureCelsius = this.maxOf { it.temperatureCelsius },
        weatherImage = this.first().weatherStatus.getWeatherImage(this.first().isDay.toTimeTheme()),
        weatherDescription = this.first().weatherStatus.getWeatherDescription()
    )
}