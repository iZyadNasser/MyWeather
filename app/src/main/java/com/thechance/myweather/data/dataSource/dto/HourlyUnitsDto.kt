package com.thechance.myweather.data.dataSource.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnitsDto(
    val time: String?,
    @SerialName("temperature_2m")
    val temperature2m: String?,
    @SerialName("apparent_temperature")
    val apparentTemperature: String?,
    @SerialName("weathercode")
    val weatherCode: String?,
    @SerialName("wind_speed_10m")
    val windSpeed10m: String?,
    @SerialName("relativehumidity_2m")
    val relativeHumidity2m: String?,
    @SerialName("precipitation_probability")
    val precipitationProbability: String?,
    @SerialName("pressure_msl")
    val pressureMsl: String?,
    @SerialName("uv_index")
    val uvIndex: String?
)