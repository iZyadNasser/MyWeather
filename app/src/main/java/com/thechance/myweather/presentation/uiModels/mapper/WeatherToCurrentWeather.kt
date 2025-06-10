package com.thechance.myweather.presentation.uiModels.mapper

import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.presentation.uiModels.CurrentWeather

fun Weather.toCurrentWeather(
    maxTemperatureCelsius: Double,
    minTemperatureCelsius: Double
): CurrentWeather {
    return CurrentWeather(
        temperatureCelsius = this.temperatureCelsius,
        maxTemperatureCelsius = maxTemperatureCelsius,
        minTemperatureCelsius = minTemperatureCelsius,
        weatherImage = this.weatherStatus.getWeatherImage(this.isDay.toTimeTheme()),
        weatherDescription = this.weatherStatus.getWeatherDescription(),
        windSpeedKmPerHour = this.windSpeedKmPerHour,
        relativeHumidityPercentage = this.relativeHumidityPercentage,
        pressureMslHPerA = this.pressureMslHPerA,
        time = this.time,
        isDay = this.isDay,
        feelsLikeTemperatureCelsius = this.feelsLikeTemperatureCelsius,
        rainPrecipitationPercent = this.rainPrecipitationPercent,
        uvIndex = this.uvIndex
    )

}