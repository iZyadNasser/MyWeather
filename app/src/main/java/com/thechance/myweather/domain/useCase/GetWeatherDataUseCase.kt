package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.dataSource.DayWeather
import com.thechance.myweather.domain.dataSource.WeatherDataSource

class GetWeatherDataUseCase(
    private val weatherDataSource: WeatherDataSource,
    private val sortWeatherDataUseCase: SortWeatherDataUseCase
) {
    suspend operator fun invoke(lat: Double, lon: Double): Result<List<DayWeather>> {
        return weatherDataSource.get8DaysWeatherData(lat, lon)
            .onSuccess {
                Result.success(sortWeatherDataUseCase(it))
            }
            .onFailure {
                Result.failure<List<DayWeather>>(it)
            }
    }
}