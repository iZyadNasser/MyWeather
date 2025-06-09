package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Immutable
import com.thechance.myweather.domain.model.UserLocation
import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.uiModels.CurrentWeather
import com.thechance.myweather.presentation.uiModels.DailyWeather
import com.thechance.myweather.presentation.uiModels.HourlyWeather
import com.thechance.myweather.presentation.uiModels.TimeTheme

@Immutable
data class WeatherState(
    val isLoading: Boolean = false,
    val location: UserLocation? = null,
    val timeTheme: TimeTheme = TimeTheme.DAY,
    val currentWeather: CurrentWeather? = null,
    val hourlyWeather: List<HourlyWeather> = emptyList(),
    val dailyWeather: List<DailyWeather> = emptyList(),
    val themeColor: ThemeColor = DayThemeColor
)
