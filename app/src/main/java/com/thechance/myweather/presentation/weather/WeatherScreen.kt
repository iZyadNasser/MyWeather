package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.MyWeatherTheme
import com.thechance.myweather.presentation.ui.theme.ThemeColor

@Composable
fun WeatherScreen(
    state: WeatherState,
    themeColor: ThemeColor,
) {

}

@Preview
@Composable
private fun PreviewWeatherScreen() {
    MyWeatherTheme {
        WeatherScreen(
            state = WeatherState(),
            themeColor = DayThemeColor
        )
    }
}