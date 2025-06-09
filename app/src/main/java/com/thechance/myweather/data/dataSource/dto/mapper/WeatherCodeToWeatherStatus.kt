package com.thechance.myweather.data.dataSource.dto.mapper

import com.thechance.myweather.domain.model.WeatherStatus

fun Int.toWeatherStatus(): WeatherStatus {
    return when (this) {
        0 -> WeatherStatus.CLEAR_SKY
        1 -> WeatherStatus.MAINLY_CLEAR
        2 -> WeatherStatus.PARTLY_CLOUDY
        3 -> WeatherStatus.OVERCAST
        45 -> WeatherStatus.FOG
        48 -> WeatherStatus.DEPOSITING_RIME_FOG
        51 -> WeatherStatus.LIGHT_DRIZZLE
        53 -> WeatherStatus.MODERATE_DRIZZLE
        55 -> WeatherStatus.DENSE_DRIZZLE
        56 -> WeatherStatus.LIGHT_FREEZING_DRIZZLE
        57 -> WeatherStatus.DENSE_FREEZING_DRIZZLE
        61 -> WeatherStatus.SLIGHT_RAIN
        63 -> WeatherStatus.MODERATE_RAIN
        65 -> WeatherStatus.HEAVY_RAIN
        66 -> WeatherStatus.LIGHT_FREEZING_RAIN
        67 -> WeatherStatus.HEAVY_FREEZING_RAIN
        71 -> WeatherStatus.SLIGHT_SNOW_FALL
        73 -> WeatherStatus.MODERATE_SNOW_FALL
        75 -> WeatherStatus.HEAVY_SNOW_FALL
        77 -> WeatherStatus.SNOW_GRAINS
        80 -> WeatherStatus.SLIGHT_RAIN_SHOWERS
        81 -> WeatherStatus.MODERATE_RAIN_SHOWERS
        82 -> WeatherStatus.VIOLENT_RAIN_SHOWERS
        85 -> WeatherStatus.SLIGHT_SNOW_SHOWERS
        86 -> WeatherStatus.HEAVY_SNOW_SHOWERS
        95 -> WeatherStatus.SLIGHT_OR_MODERATE_THUNDERSTORM
        96 -> WeatherStatus.THUNDERSTORM_WITH_SLIGHT_HAIL
        99 -> WeatherStatus.THUNDERSTORM_WITH_HEAVY_HAIL
        else -> throw IllegalArgumentException("Unsupported weather code: $this")
    }
}