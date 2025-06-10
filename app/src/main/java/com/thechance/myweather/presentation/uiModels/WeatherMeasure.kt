package com.thechance.myweather.presentation.uiModels

import com.thechance.myweather.presentation.utils.UiImage
import com.thechance.myweather.presentation.utils.UiText

data class WeatherMeasure(
    val image: UiImage,
    val value: String,
    val unit: UiText,
    val measure: UiText,
)
