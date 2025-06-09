package com.thechance.myweather.data.dataSource.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyDto(
    val time: List<String?>?,
    @SerialName("temperature_2m")
    val temperature2m: List<Double?>?,
    @SerialName("apparent_temperature")
    val apparentTemperature: List<Double?>?,
    @SerialName("weathercode")
    val weatherCode: List<Int?>?,
    @SerialName("wind_speed_10m")
    val windSpeed10m: List<Double?>?,
    @SerialName("relativehumidity_2m")
    val relativeHumidity2m: List<Int?>?,
    @SerialName("precipitation_probability")
    val precipitationProbability: List<Double?>?,
    @SerialName("pressure_msl")
    val pressureMsl: List<Double?>?,
    @SerialName("uv_index")
    val uvIndex: List<Double?>?,
    @SerialName("is_day")
    val isDay: List<Int?>?
)