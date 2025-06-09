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
                WeatherStatus.CLEAR_SKY -> R.drawable.im_clear_sky
                WeatherStatus.MAINLY_CLEAR -> R.drawable.im_mainly_clear
                WeatherStatus.PARTLY_CLOUDY -> R.drawable.im_partly_cloudy
                WeatherStatus.OVERCAST -> R.drawable.im_overcast
                WeatherStatus.FOG -> R.drawable.im_fog
                WeatherStatus.DEPOSITING_RIME_FOG -> R.drawable.im_depositing_rime_fog
                WeatherStatus.LIGHT_DRIZZLE -> R.drawable.im_light_drizzle
                WeatherStatus.MODERATE_DRIZZLE -> R.drawable.im_moderate_drizzle
                WeatherStatus.DENSE_DRIZZLE -> R.drawable.im_dense_drizzle
                WeatherStatus.LIGHT_FREEZING_DRIZZLE -> R.drawable.im_light_freezing_drizzle
                WeatherStatus.DENSE_FREEZING_DRIZZLE -> R.drawable.im_dense_freezing_drizzle
                WeatherStatus.SLIGHT_RAIN -> R.drawable.im_slight_rain
                WeatherStatus.MODERATE_RAIN -> R.drawable.im_moderate_rain
                WeatherStatus.HEAVY_RAIN -> R.drawable.im_heavy_rain
                WeatherStatus.LIGHT_FREEZING_RAIN -> R.drawable.im_light_freezing_rain
                WeatherStatus.HEAVY_FREEZING_RAIN -> R.drawable.im_heavy_freezing_rain
                WeatherStatus.SLIGHT_SNOW_FALL -> R.drawable.im_slight_snow_fall
                WeatherStatus.MODERATE_SNOW_FALL -> R.drawable.im_moderate_snow_fall
                WeatherStatus.HEAVY_SNOW_FALL -> R.drawable.im_heavy_snow_fall_day
                WeatherStatus.SNOW_GRAINS -> R.drawable.im_snow_grains
                WeatherStatus.SLIGHT_RAIN_SHOWERS -> R.drawable.im_slight_rain_shower
                WeatherStatus.MODERATE_RAIN_SHOWERS -> R.drawable.im_moderate_rain_shower
                WeatherStatus.VIOLENT_RAIN_SHOWERS -> R.drawable.im_violent_rain_shower
                WeatherStatus.SLIGHT_SNOW_SHOWERS -> R.drawable.im_slight_snow_shower
                WeatherStatus.HEAVY_SNOW_SHOWERS -> R.drawable.im_heavy_snow_shower
                WeatherStatus.SLIGHT_OR_MODERATE_THUNDERSTORM -> R.drawable.im_thunder_storm
                WeatherStatus.THUNDERSTORM_WITH_SLIGHT_HAIL -> R.drawable.im_thunder_storm_with_slight_hail
                WeatherStatus.THUNDERSTORM_WITH_HEAVY_HAIL -> R.drawable.im_thunder_storm_with_heavy_hail
            }
        )
    } else {
        UiImage.Drawable(
            id = when (this) {
                WeatherStatus.CLEAR_SKY -> R.drawable.im_clear_sky_night
                WeatherStatus.MAINLY_CLEAR -> R.drawable.im_mainly_cleaer_night
                WeatherStatus.PARTLY_CLOUDY -> R.drawable.im_partly_cloudy_night
                WeatherStatus.OVERCAST -> R.drawable.im_over_cast_night
                WeatherStatus.FOG -> R.drawable.im_fog_night
                WeatherStatus.DEPOSITING_RIME_FOG -> R.drawable.im_depositing_rime_fog_night
                WeatherStatus.LIGHT_DRIZZLE -> R.drawable.im_light_drizzle_night
                WeatherStatus.MODERATE_DRIZZLE -> R.drawable.im_moderate_drizzle_night
                WeatherStatus.DENSE_DRIZZLE -> R.drawable.im_dense_drizzle_night
                WeatherStatus.LIGHT_FREEZING_DRIZZLE -> R.drawable.im_light_freezing_drizzle_night
                WeatherStatus.DENSE_FREEZING_DRIZZLE -> R.drawable.im_dense_freezing_drizzle_night
                WeatherStatus.SLIGHT_RAIN -> R.drawable.im_slight_rain_night
                WeatherStatus.MODERATE_RAIN -> R.drawable.im_moderate_rain_night
                WeatherStatus.HEAVY_RAIN -> R.drawable.im_heavy_rain_night
                WeatherStatus.LIGHT_FREEZING_RAIN -> R.drawable.im_light_freezing_rain_night
                WeatherStatus.HEAVY_FREEZING_RAIN -> R.drawable.im_heavy_freezing_rain
                WeatherStatus.SLIGHT_SNOW_FALL -> R.drawable.im_slight_snow_fall_night
                WeatherStatus.MODERATE_SNOW_FALL -> R.drawable.im_moderate_snow_fall_night
                WeatherStatus.HEAVY_SNOW_FALL -> R.drawable.im_heavy_snow_fall
                WeatherStatus.SNOW_GRAINS -> R.drawable.im_snow_grains_night
                WeatherStatus.SLIGHT_RAIN_SHOWERS -> R.drawable.im_slight_rain_night
                WeatherStatus.MODERATE_RAIN_SHOWERS -> R.drawable.im_moderate_rain_shower_night
                WeatherStatus.VIOLENT_RAIN_SHOWERS -> R.drawable.im_violent_rain_shower_night
                WeatherStatus.SLIGHT_SNOW_SHOWERS -> R.drawable.im_slight_snow_shower_night
                WeatherStatus.HEAVY_SNOW_SHOWERS -> R.drawable.im_heavy_snow_shower_night
                WeatherStatus.SLIGHT_OR_MODERATE_THUNDERSTORM -> R.drawable.im_thunder_storm_night
                WeatherStatus.THUNDERSTORM_WITH_SLIGHT_HAIL -> R.drawable.im_thunder_storm_with_slight_hail_night
                WeatherStatus.THUNDERSTORM_WITH_HEAVY_HAIL -> R.drawable.im_thunder_storm_with_heavy_hail_night
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