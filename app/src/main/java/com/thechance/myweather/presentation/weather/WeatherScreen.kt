package com.thechance.myweather.presentation.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.myweather.presentation.ui.theme.MyWeatherTheme

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    state: WeatherState,
) {
    Column {
        if (!state.isLoading) {
            Text(
                text = state.location?.cityName ?: "Unknown City",
                modifier = modifier
                    .padding(
                        bottom = 64.dp
                    )
            )

            Text(
                text = state.location?.latitude.toString(),
                modifier = modifier
                    .padding(
                        bottom = 64.dp
                    )
            )

            Text(
                text = state.location?.longitude.toString(),
                modifier = modifier
                    .padding(
                        bottom = 64.dp
                    )
            )
        }
    }

}

@Preview
@Composable
private fun PreviewWeatherScreen() {
    MyWeatherTheme {
        WeatherScreen(
            state = WeatherState(),
        )
    }
}

object DummyInteractionHandler : InteractionHandler {
    override fun getUserLocation() {
        TODO("Not yet implemented")
    }

}