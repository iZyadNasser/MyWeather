package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.model.Weather
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

class WeatherDataHandler private constructor() {

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

    fun getHighestTemperatureOfDate(date: LocalDate): Weather {
        return weatherData
            .filter { it.time.date == date }
            .maxBy { it.temperatureCelsius }
    }

    fun getLowestTemperatureOfDate(date: LocalDate): Weather {
        return weatherData
            .filter { it.time.date == date }
            .minBy { it.temperatureCelsius }
    }

    companion object {

        private var instance: WeatherDataHandler? = null
        private lateinit var weatherData: List<Weather>
        private lateinit var currentTime: LocalDateTime

        fun setupWeatherFormatter(
            weatherList: List<Weather>,
            time: LocalDateTime
        ): WeatherDataHandler {
            weatherData = weatherList
            currentTime = time

            sortWeatherData()
            filterWeatherDataToOnlyRemainingHours()

            return instance ?: WeatherDataHandler().also { instance = it }
        }

        private fun filterWeatherDataToOnlyRemainingHours() {
            weatherData = weatherData.filter {
                it.time >= currentTime
            }
        }

        private fun sortWeatherData() {
            weatherData = weatherData.sortedBy { it.time }
        }

        fun sortWeatherData(weatherList: List<Weather> = weatherData): List<Weather> {
            return weatherList.sortedBy { it.time }
        }
    }
}