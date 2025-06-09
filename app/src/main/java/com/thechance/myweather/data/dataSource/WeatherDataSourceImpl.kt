package com.thechance.myweather.data.dataSource

import com.thechance.myweather.domain.dataSource.DayWeather
import com.thechance.myweather.domain.dataSource.WeatherDataSource

class WeatherDataSourceImpl: WeatherDataSource {
    override suspend fun get8DaysWeatherData(
        lat: Double,
        lon: Double
    ): Result<List<DayWeather>> {
        TODO("Not yet implemented")
    }
}