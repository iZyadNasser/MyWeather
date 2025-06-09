package com.thechance.myweather.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.MyWeatherTheme
import com.thechance.myweather.presentation.ui.theme.NightThemeColor

@Composable
fun WeatherScreen(
    state: WeatherState,
) {
    val themeColor = state.themeColor

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColor.backgroundGradientColor)
            .statusBarsPadding()
            .padding(
                start = 12.dp,
                top = 24.dp,
                end = 12.dp,
                bottom = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {

        }
    }

}

@Preview(showBackground = true)
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

@Preview(showBackground = true)
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