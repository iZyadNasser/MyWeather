package com.thechance.myweather.domain.dataSource

import com.thechance.myweather.domain.model.Weather

interface WeatherDataSource {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): Result<Weather>
}