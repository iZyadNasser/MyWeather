package com.thechance.myweather.domain.dataSource

import com.thechance.myweather.domain.model.Weather

interface WeatherDataSource {

    suspend fun get8DaysWeatherData(lat: Double, lon: Double): Result<List<Weather>>

}