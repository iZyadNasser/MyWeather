package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Immutable
import com.thechance.myweather.domain.model.UserLocation
import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.presentation.uiModels.TimeTheme

@Immutable
data class WeatherState(
    val isLoading: Boolean = false,
    val location: UserLocation? = null,
    val timeTheme: TimeTheme = TimeTheme.DAY,
    val currentWeather: Weather? = null,
    val hourlyWeather: List<Weather> = emptyList(),
    val dailyWeather: List<Weather> = emptyList()
)
