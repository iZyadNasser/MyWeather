package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.MyWeatherTheme
import com.thechance.myweather.presentation.ui.theme.NightThemeColor

@Composable
fun WeatherScreen(
    state: WeatherState,
) {
    val themeColor = state.themeColor


}

@Preview
@Composable
private fun PreviewWeatherScreen() {
    MyWeatherTheme {
        WeatherScreen(
            state = WeatherState(
                themeColor = DayThemeColor
            )
        )
    }
}

@Preview
@Composable
private fun PreviewWeatherScreenNight() {
    MyWeatherTheme {
        WeatherScreen(
            state = WeatherState(
                themeColor = NightThemeColor
            )
        )
    }
}