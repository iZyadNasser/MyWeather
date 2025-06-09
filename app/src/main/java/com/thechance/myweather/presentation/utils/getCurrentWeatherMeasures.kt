package com.thechance.myweather.presentation.utils

import com.thechance.myweather.R
import com.thechance.myweather.presentation.uiModels.CurrentWeather
import com.thechance.myweather.presentation.uiModels.WeatherMeasure

fun getCurrentWeatherMeasures(currentWeather: CurrentWeather?): List<WeatherMeasure> {
    val weatherMeasures = mutableListOf<WeatherMeasure>()

    // Wind
    weatherMeasures.add(
        WeatherMeasure(
            image = UiImage.Drawable(R.drawable.ic_fast_wind),
            value = currentWeather?.windSpeedKmPerHour.toString(),
            unit = UiText.StringResource(R.string.km_h),
            measure = UiText.StringResource(R.string.wind)
        )
    )

    // Humidity
    weatherMeasures.add(
        WeatherMeasure(
            image = UiImage.Drawable(R.drawable.ic_humidity),
            value = currentWeather?.relativeHumidityPercentage.toString(),
            unit = UiText.DynamicString("%"),
            measure = UiText.StringResource(R.string.humidity)
        )
    )

    // Rain
    weatherMeasures.add(
        WeatherMeasure(
            image = UiImage.Drawable(R.drawable.ic_rain),
            value = currentWeather?.rainPrecipitationPercent.toString(),
            unit = UiText.DynamicString("%"),
            measure = UiText.StringResource(R.string.rain)
        )
    )

    // UV index
    weatherMeasures.add(
        WeatherMeasure(
            image = UiImage.Drawable(R.drawable.ic_uv_index),
            value = currentWeather?.uvIndex.toString(),
            unit = UiText.DynamicString(""),
            measure = UiText.StringResource(R.string.uv_index)
        )
    )

    // Pressure
    weatherMeasures.add(
        WeatherMeasure(
            image = UiImage.Drawable(R.drawable.ic_arrow_down),
            value = currentWeather?.pressureMslHPerA.toString(),
            unit = UiText.StringResource(R.string.hpa),
            measure = UiText.StringResource(R.string.pressure)
        )
    )

    // Feels like
    weatherMeasures.add(
        WeatherMeasure(
            image = UiImage.Drawable(R.drawable.ic_temperature),
            value = currentWeather?.feelsLikeTemperatureCelsius.toString(),
            unit = UiText.StringResource(R.string.celsius),
            measure = UiText.StringResource(R.string.feels_like)
        )
    )

    return weatherMeasures
}