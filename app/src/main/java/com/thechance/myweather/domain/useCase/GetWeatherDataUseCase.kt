package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.dataSource.WeatherDataSource
import com.thechance.myweather.domain.model.Weather

class GetWeatherDataUseCase(
    private val weatherDataSource: WeatherDataSource,
) {
    suspend operator fun invoke(lat: Double, lon: Double): Result<List<Weather>> {
        return weatherDataSource.get8DaysWeatherData(lat, lon)
            .onSuccess {
                Result.success(
                    WeatherDataHandler.sortWeatherData(it)
                )
            }
            .onFailure {
                Result.failure<List<Weather>>(it)
            }
    }
}