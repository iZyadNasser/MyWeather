package com.thechance.myweather.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.myweather.R
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.MyWeatherTheme
import com.thechance.myweather.presentation.ui.theme.NightThemeColor
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.ui.theme.Urbanist
import com.thechance.myweather.presentation.uiModels.HourlyWeather
import com.thechance.myweather.presentation.utils.formatHour
import com.thechance.myweather.presentation.utils.to12HourFormat
import com.thechance.myweather.presentation.weather.components.CurrentWeatherHeader
import com.thechance.myweather.presentation.weather.components.CurrentWeatherMeasuresSection
import com.thechance.myweather.presentation.weather.components.HourlyWeatherCard

@Composable
fun WeatherScreen(
    state: WeatherState,
) {
    val themeColor = state.themeColor
    val scrollState = rememberScrollState()

    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(128.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                color = themeColor.iconColor,
                strokeWidth = 6.dp
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(themeColor.backgroundGradientColor)
                .statusBarsPadding()
                .padding(
                    top = 24.dp,
                    bottom = 32.dp
                )
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocationRow(
                themeColor = themeColor,
                cityName = state.location?.cityName ?: "Damietta",
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 12.dp
                )
            )

            CurrentWeatherHeader(
                scrollState = scrollState,
                themeColor = themeColor,
                currentWeather = state.currentWeather,
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 24.dp
                )
            )

            CurrentWeatherMeasuresSection(
                measures = state.currentWeatherMeasures,
                themeColor = themeColor,
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 24.dp
                )
            )

            TodayWeatherSection(
                hourlyWeather = state.hourlyWeather,
                themeColor = themeColor,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
private fun LocationRow(
    themeColor: ThemeColor,
    cityName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_location),
            contentDescription = stringResource(R.string.location),
            tint = themeColor.secondaryTextColor,
            modifier = Modifier.padding(end = 4.dp)
        )

        Text(
            text = cityName,
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp
            ),
            color = themeColor.secondaryTextColor
        )
    }
}

@Composable
fun TodayWeatherSection(
    hourlyWeather: List<HourlyWeather>,
    themeColor: ThemeColor,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.today),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            ),
            color = themeColor.textColor,
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 12.dp
                )
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(
                horizontal = 12.dp
            )
        ) {

            items(hourlyWeather) { weather ->
                HourlyWeatherCard(
                    image = weather.weatherImage,
                    status = weather.weatherDescription.asString(),
                    value = weather.temperatureCelsius.toInt().toString(),
                    unit = stringResource(R.string.celsius),
                    time = weather.hour.to12HourFormat().toString().formatHour(),
                    theme = themeColor
                )
            }
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
                themeColor = NightThemeColor,
            )
        )
    }
}