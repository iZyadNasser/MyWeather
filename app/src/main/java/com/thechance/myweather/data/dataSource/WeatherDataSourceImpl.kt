package com.thechance.myweather.data.dataSource

import com.thechance.myweather.data.dataSource.dto.WeatherDto
import com.thechance.myweather.data.dataSource.dto.mapper.toDomainWeatherList
import com.thechance.myweather.data.utils.constructUrl
import com.thechance.myweather.data.utils.safeCall
import com.thechance.myweather.domain.dataSource.WeatherDataSource
import com.thechance.myweather.domain.model.Weather
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherDataSourceImpl(
    private val httpClient: HttpClient
) : WeatherDataSource {
    override suspend fun get8DaysWeatherData(
        lat: Double,
        lon: Double
    ): Result<List<Weather>> = withContext(Dispatchers.IO) {
        safeCall<WeatherDto> {
            httpClient.get(constructUrl("forecast")) {
                parameter("latitude", lat)
                parameter("longitude", lon)
                parameter("timezone", "auto")
                parameter("forecast_days", 8)
                parameter("hourly", HOURLY_TAGS)

            }.body()
        }.map { it.toDomainWeatherList() }
    }

    companion object {
        private const val HOURLY_TAGS =
            "temperature_2m,apparent_temperature,weathercode,wind_speed_10m,relativehumidity_2m,precipitation_probability,pressure_msl,uv_index,is_day"
    }
}