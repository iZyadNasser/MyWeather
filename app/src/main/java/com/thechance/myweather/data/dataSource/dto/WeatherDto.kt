package com.thechance.myweather.data.dataSource.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val latitude: Double?,
    val longitude: Double?,
    @SerialName("generationtime_ms")
    val generationTimeMs: Double?,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int?,
    val timezone: String?,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    val elevation: Double?,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnitsDto?,
    val hourly: HourlyDto?
)