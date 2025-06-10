package com.thechance.myweather.presentation.uiModels.mapper

import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.presentation.uiModels.HourlyWeather

fun Weather.toHourlyWeather(): HourlyWeather {
    return HourlyWeather(
        hour = time.hour,
        temperatureCelsius = temperatureCelsius,
        weatherImage = this.weatherStatus.getWeatherImage(this.isDay.toTimeTheme()),
        weatherDescription = this.weatherStatus.getWeatherDescription()
    )
}