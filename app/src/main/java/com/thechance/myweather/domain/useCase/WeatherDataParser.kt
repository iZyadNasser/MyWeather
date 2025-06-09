package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.model.Weather
import kotlinx.datetime.LocalDateTime

class WeatherDataParser private constructor() {

    fun getCurrentWeather(): Weather {
        return weatherData.first()
    }

    fun getNext24HoursHourlyWeather(): List<Weather> {
        return weatherData.take(25).drop(1)
    }

    fun getNext7DaysDailyWeather(): List<Weather> {
        return weatherData.filter {
            it.time.date > currentTime.date
        }
    }

    companion object {

        private var instance: WeatherDataParser? = null
        private lateinit var weatherData: List<Weather>
        private lateinit var currentTime: LocalDateTime

        fun setupWeatherFormatter(
            weatherList: List<Weather>,
            time: LocalDateTime
        ): WeatherDataParser {
            weatherData = weatherList
            currentTime = time

            sortWeatherData()
            filterWeatherDataToOnlyRemainingHours()

            return instance ?: WeatherDataParser().also { instance = it }
        }

        private fun filterWeatherDataToOnlyRemainingHours() {
            weatherData = weatherData.filter {
                it.time >= currentTime
            }
        }

        fun sortWeatherData() {
            weatherData = weatherData.sortedBy { it.time }
        }

        fun sortWeatherData(weatherList: List<Weather> = weatherData): List<Weather> {
            return weatherList.sortedBy { it.time }
        }
    }
}