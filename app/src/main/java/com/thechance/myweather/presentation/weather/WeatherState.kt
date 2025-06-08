package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Immutable
import com.thechance.myweather.domain.model.UserLocation

@Immutable
data class WeatherState(
    val isLoading: Boolean = false,
    val location: UserLocation? = null,

)
