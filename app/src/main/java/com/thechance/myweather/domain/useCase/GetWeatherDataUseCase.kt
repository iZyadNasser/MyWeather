package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.dataSource.WeatherDataSource
import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.domain.model.WeatherData

class GetWeatherDataUseCase(
    private val weatherDataSource: WeatherDataSource,
    private val sortWeatherDataUseCase: SortWeatherDataUseCase
) {
    suspend operator fun invoke(lat: Double, lon: Double): Result<WeatherData> {
        return convertToWeatherData(weatherDataSource.get8DaysWeatherData(lat, lon))
    }

    private fun convertToWeatherData(weatherList: Result<List<Weather>>): Result<WeatherData> {
        return if (weatherList.isSuccess) {
            val sortedWeatherList = sortWeatherDataUseCase(weatherList.getOrNull()!!)
            Result.success(WeatherData(
                currentWeather = sortedWeatherList.first(),
                next7DaysWeather = sortedWeatherList.drop(1)
            ))
        } else {
            Result.failure(weatherList.exceptionOrNull()!!)
        }
    }
}