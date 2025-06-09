package com.thechance.myweather.data.dataSource.dto.mapper

import com.thechance.myweather.data.dataSource.dto.WeatherDto
import com.thechance.myweather.domain.model.Weather
import kotlinx.datetime.LocalDateTime

fun WeatherDto.toDomainWeatherList(): List<Weather> {
    return hourly?.time?.mapIndexed { index, time ->
        createWeather(
            time = time ?: LocalDateTime.toString(),
            temperature = hourly.temperature2m?.get(index) ?: 0.0,
            apparentTemperature = hourly.apparentTemperature?.get(index) ?: 0.0,
            weatherCode = hourly.weatherCode?.get(index) ?: 0,
            windSpeed = hourly.windSpeed10m?.get(index) ?: 0.0,
            humidity = hourly.relativeHumidity2m?.get(index) ?: 0,
            precipitationProbability = hourly.precipitationProbability?.get(index) ?: 0.0,
            pressure = hourly.pressureMsl?.get(index) ?: 0.0,
            uvIndex = hourly.uvIndex?.get(index) ?: 0.0,
            isDay = hourly.isDay?.get(index) ?: 0
        )
    } ?: emptyList()
}

private fun createWeather(
    time: String,
    temperature: Double,
    apparentTemperature: Double,
    weatherCode: Int,
    windSpeed: Double,
    humidity: Int,
    precipitationProbability: Double,
    pressure: Double,
    uvIndex: Double,
    isDay: Int
): Weather {
    return Weather(
        time = LocalDateTime.parse(time),
        temperatureCelsius = temperature,
        feelsLikeTemperatureCelsius = apparentTemperature,
        weatherCode = weatherCode,
        windSpeedKmPerHour = windSpeed,
        relativeHumidityPercentage = humidity,
        rainPrecipitationPercent = precipitationProbability.toInt(),
        pressureMslHPerA = pressure,
        uvIndex = uvIndex,
        isDay = isDay != 0
    )
}