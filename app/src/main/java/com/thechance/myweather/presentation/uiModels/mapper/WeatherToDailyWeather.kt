package com.thechance.myweather.presentation.uiModels.mapper

import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.presentation.uiModels.DailyWeather
import com.thechance.myweather.presentation.uiModels.TimeTheme

fun List<Weather>.toDailyWeather(): DailyWeather {
    return DailyWeather(
        dayOfWeek = this.first().time.dayOfWeek.name,
        temperatureCelsius = this.first().temperatureCelsius,
        minTemperatureCelsius = this.minOf { it.temperatureCelsius },
        maxTemperatureCelsius = this.maxOf { it.temperatureCelsius },
        weatherImage = this.first().weatherStatus.getWeatherImage(TimeTheme.DAY),
        weatherDescription = this.first().weatherStatus.getWeatherDescription()
    )
}