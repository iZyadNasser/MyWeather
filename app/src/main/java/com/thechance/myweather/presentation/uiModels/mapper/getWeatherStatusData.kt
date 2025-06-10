package com.thechance.myweather.presentation.uiModels.mapper

import com.thechance.myweather.R
import com.thechance.myweather.domain.model.WeatherStatus
import com.thechance.myweather.presentation.uiModels.TimeTheme
import com.thechance.myweather.presentation.utils.UiImage
import com.thechance.myweather.presentation.utils.UiText

fun WeatherStatus.getWeatherImage(timeTheme: TimeTheme): UiImage {
    return if (timeTheme == TimeTheme.DAY) {
        UiImage.Drawable(
            id = when (this) {
                WeatherStatus.CLEAR_SKY -> R.drawable.light_clear_sky
                WeatherStatus.MAINLY_CLEAR -> R.drawable.light_mainly_clear
                WeatherStatus.PARTLY_CLOUDY -> R.drawable.light_partialy_cloudy
                WeatherStatus.OVERCAST -> R.drawable.light_overcast
                WeatherStatus.FOG -> R.drawable.light_fog
                WeatherStatus.DEPOSITING_RIME_FOG -> R.drawable.light_rime_fog
                WeatherStatus.LIGHT_DRIZZLE -> R.drawable.light_drizzle_light
                WeatherStatus.MODERATE_DRIZZLE -> R.drawable.light_drizzle_moderate
                WeatherStatus.DENSE_DRIZZLE -> R.drawable.light_drizzle_intensity
                WeatherStatus.LIGHT_FREEZING_DRIZZLE -> R.drawable.light_freezing_drizzle_light
                WeatherStatus.DENSE_FREEZING_DRIZZLE -> R.drawable.light_freezing_drizzle_intensity
                WeatherStatus.SLIGHT_RAIN -> R.drawable.light_rain_slight
                WeatherStatus.MODERATE_RAIN -> R.drawable.light_rain_moderate
                WeatherStatus.HEAVY_RAIN -> R.drawable.light_rain_intensity
                WeatherStatus.LIGHT_FREEZING_RAIN -> R.drawable.light_freezing_rain_light
                WeatherStatus.HEAVY_FREEZING_RAIN -> R.drawable.light_freezing_rain_heavy
                WeatherStatus.SLIGHT_SNOW_FALL -> R.drawable.light_snow_fall_light
                WeatherStatus.MODERATE_SNOW_FALL -> R.drawable.light_snow_fall_moderate
                WeatherStatus.HEAVY_SNOW_FALL -> R.drawable.light_snowfall_heavy
                WeatherStatus.SNOW_GRAINS -> R.drawable.light_snow_grains
                WeatherStatus.SLIGHT_RAIN_SHOWERS -> R.drawable.light_rain_shower_slight
                WeatherStatus.MODERATE_RAIN_SHOWERS -> R.drawable.light_rain_shower_moderate
                WeatherStatus.VIOLENT_RAIN_SHOWERS -> R.drawable.light_rain_shower_violent
                WeatherStatus.SLIGHT_SNOW_SHOWERS -> R.drawable.light_snow_shower_slight
                WeatherStatus.HEAVY_SNOW_SHOWERS -> R.drawable.light_snow_shower_heavy
                WeatherStatus.SLIGHT_OR_MODERATE_THUNDERSTORM -> R.drawable.light_thunderstorm_moderate
                WeatherStatus.THUNDERSTORM_WITH_SLIGHT_HAIL -> R.drawable.light_thunderstorm_with_slight_hail
                WeatherStatus.THUNDERSTORM_WITH_HEAVY_HAIL -> R.drawable.light_thunderstrom_with_heavy_hail
            }
        )
    } else {
        UiImage.Drawable(
            id = when (this) {
                WeatherStatus.CLEAR_SKY -> R.drawable.night_clear_sky
                WeatherStatus.MAINLY_CLEAR -> R.drawable.night_mainly_clear
                WeatherStatus.PARTLY_CLOUDY -> R.drawable.night_partly_cloudy
                WeatherStatus.OVERCAST -> R.drawable.night_overcast
                WeatherStatus.FOG -> R.drawable.night_fog
                WeatherStatus.DEPOSITING_RIME_FOG -> R.drawable.night_rime_fog
                WeatherStatus.LIGHT_DRIZZLE -> R.drawable.night_drizzle_light
                WeatherStatus.MODERATE_DRIZZLE -> R.drawable.night_drizzle_moderate
                WeatherStatus.DENSE_DRIZZLE -> R.drawable.night_drizzle_intensity
                WeatherStatus.LIGHT_FREEZING_DRIZZLE -> R.drawable.night_freezing_drizzle_light
                WeatherStatus.DENSE_FREEZING_DRIZZLE -> R.drawable.night_freezing_drizzle_intensity
                WeatherStatus.SLIGHT_RAIN -> R.drawable.night_rain_slight
                WeatherStatus.MODERATE_RAIN -> R.drawable.night_rain_moderate
                WeatherStatus.HEAVY_RAIN -> R.drawable.night_rain_intensity
                WeatherStatus.LIGHT_FREEZING_RAIN -> R.drawable.night_freezing_rain_light
                WeatherStatus.HEAVY_FREEZING_RAIN -> R.drawable.night_freezing_rain_heavy
                WeatherStatus.SLIGHT_SNOW_FALL -> R.drawable.night_snowfall_slight
                WeatherStatus.MODERATE_SNOW_FALL -> R.drawable.night_snowfall_moderate
                WeatherStatus.HEAVY_SNOW_FALL -> R.drawable.night_snowfall_heavy
                WeatherStatus.SNOW_GRAINS -> R.drawable.night_snow_grains
                WeatherStatus.SLIGHT_RAIN_SHOWERS -> R.drawable.night_rain_shower_slight
                WeatherStatus.MODERATE_RAIN_SHOWERS -> R.drawable.night_rain_shower_moderate
                WeatherStatus.VIOLENT_RAIN_SHOWERS -> R.drawable.night_rain_shower_violent
                WeatherStatus.SLIGHT_SNOW_SHOWERS -> R.drawable.night_snow_shower_slight
                WeatherStatus.HEAVY_SNOW_SHOWERS -> R.drawable.night_snow_shower_heavy
                WeatherStatus.SLIGHT_OR_MODERATE_THUNDERSTORM -> R.drawable.night_thunderstorm_moderate
                WeatherStatus.THUNDERSTORM_WITH_SLIGHT_HAIL -> R.drawable.night_thunderstorm_with_slight_hail
                WeatherStatus.THUNDERSTORM_WITH_HEAVY_HAIL -> R.drawable.night_thunderstrom_with_heavy_hail
            }
        )
    }
}

fun WeatherStatus.getWeatherDescription(): UiText {
    return UiText.StringResource(
        id = when (this) {
            WeatherStatus.CLEAR_SKY -> R.string.clear_sky
            WeatherStatus.MAINLY_CLEAR -> R.string.mainly_clear
            WeatherStatus.PARTLY_CLOUDY -> R.string.partly_cloudy
            WeatherStatus.OVERCAST -> R.string.overcast
            WeatherStatus.FOG -> R.string.fog
            WeatherStatus.DEPOSITING_RIME_FOG -> R.string.depositing_rime_fog
            WeatherStatus.LIGHT_DRIZZLE -> R.string.light_drizzle
            WeatherStatus.MODERATE_DRIZZLE -> R.string.moderate_drizzle
            WeatherStatus.DENSE_DRIZZLE -> R.string.dense_drizzle
            WeatherStatus.LIGHT_FREEZING_DRIZZLE -> R.string.light_freezing_drizzle
            WeatherStatus.DENSE_FREEZING_DRIZZLE -> R.string.dense_freezing_drizzle
            WeatherStatus.SLIGHT_RAIN -> R.string.slight_rain
            WeatherStatus.MODERATE_RAIN -> R.string.moderate_rain
            WeatherStatus.HEAVY_RAIN -> R.string.heavy_rain
            WeatherStatus.LIGHT_FREEZING_RAIN -> R.string.light_freezing_rain
            WeatherStatus.HEAVY_FREEZING_RAIN -> R.string.heavy_freezing_rain
            WeatherStatus.SLIGHT_SNOW_FALL -> R.string.slight_snow_fall
            WeatherStatus.MODERATE_SNOW_FALL -> R.string.moderate_snow_fall
            WeatherStatus.HEAVY_SNOW_FALL -> R.string.heavy_snow_fall
            WeatherStatus.SNOW_GRAINS -> R.string.snow_grains
            WeatherStatus.SLIGHT_RAIN_SHOWERS -> R.string.slight_rain_showers
            WeatherStatus.MODERATE_RAIN_SHOWERS -> R.string.moderate_rain_showers
            WeatherStatus.VIOLENT_RAIN_SHOWERS -> R.string.violent_rain_showers
            WeatherStatus.SLIGHT_SNOW_SHOWERS -> R.string.slight_snow_showers
            WeatherStatus.HEAVY_SNOW_SHOWERS -> R.string.heavy_snow_showers
            WeatherStatus.SLIGHT_OR_MODERATE_THUNDERSTORM -> R.string.slight_or_moderate_thunderstorm
            WeatherStatus.THUNDERSTORM_WITH_SLIGHT_HAIL -> R.string.thunderstorm_with_slight_hail
            WeatherStatus.THUNDERSTORM_WITH_HEAVY_HAIL -> R.string.thunderstorm_with_heavy_hail
        }
    )
}