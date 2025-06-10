package com.thechance.myweather.presentation.weather.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.myweather.R
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.ui.theme.Urbanist
import com.thechance.myweather.presentation.uiModels.CurrentWeather

@Composable
fun CurrentWeatherHeader(
    scrollState: ScrollState,
    themeColor: ThemeColor,
    currentWeather: CurrentWeather?,
    cityName: String,
    modifier: Modifier = Modifier
) {
    LocationRow(
        themeColor = themeColor,
        cityName = cityName,
        modifier = Modifier.padding(
            start = 12.dp,
            end = 12.dp,
            bottom = 12.dp,
            top = 24.dp,
        )
    )

    // TODO
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