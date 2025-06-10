package com.thechance.myweather.presentation.weather.components

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.thechance.myweather.R
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.ui.theme.Urbanist
import com.thechance.myweather.presentation.uiModels.CurrentWeather
import com.thechance.myweather.presentation.weather.ANIMATION_DURATION


@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CurrentWeatherHeader(
    scrollProgress: Float,
    themeColor: ThemeColor,
    currentWeather: CurrentWeather?,
    unit: String,
    modifier: Modifier = Modifier
) {

    val illustrationHeight by animateDpAsState(
        targetValue = lerp(200.dp, 112.dp, scrollProgress),
        animationSpec = tween(ANIMATION_DURATION, easing = FastOutSlowInEasing),
        label = "illustration_height"
    )

    val illustrationOffset by animateIntOffsetAsState(
        targetValue = lerp(IntOffset(0, 0), IntOffset(-90, 35), scrollProgress),
        animationSpec = tween(ANIMATION_DURATION, easing = FastOutSlowInEasing),
        label = "illustration_offset"
    )

    val infoCardOffset by animateIntOffsetAsState(
        targetValue = lerp(IntOffset(0, 0), IntOffset(80, -(90)), scrollProgress),
        animationSpec = tween(ANIMATION_DURATION, easing = FastOutSlowInEasing),
        label = "info_card_offset"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        WeatherIllustration(
            illustrationHeight = illustrationHeight,
            isCompact = false,
            currentWeather = currentWeather,
            modifier = Modifier
                .offset(illustrationOffset.x.dp, illustrationOffset.y.dp)
                .shadow(150.dp, spotColor = themeColor.blurColor)
                .padding(bottom = 12.dp)
        )
        WeatherInfo(
            themeColor = themeColor,
            currentWeather = currentWeather,
            unit = unit,
            modifier = Modifier
                .offset(infoCardOffset.x.dp, infoCardOffset.y.dp)
        )
    }
}

@Composable
fun WeatherIllustration(
    illustrationHeight: Dp,
    isCompact: Boolean,
    currentWeather: CurrentWeather?,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = if (isCompact) Alignment.BottomStart else Alignment.BottomCenter
    ) {
        currentWeather?.weatherImage?.let {
            Image(
                painter = it.asPainter(),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(illustrationHeight)
            )
        }
    }
}

@Composable
fun WeatherInfo(
    currentWeather: CurrentWeather?,
    unit: String,
    themeColor: ThemeColor,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "${currentWeather?.temperatureCelsius?.toInt()?.toString() ?: ""}$unit",
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.SemiBold,
                fontSize = 64.sp,
                letterSpacing = 0.25.sp
            ),
            color = themeColor.textColor
        )

        Text(
            text = currentWeather?.weatherDescription?.asString() ?: "",
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            ),
            color = themeColor.textColor.copy(alpha = 0.6f),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(themeColor.textBackgroundColor)
                .padding(
                    horizontal = 24.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_small_arrow_up),
                contentDescription = stringResource(R.string.highest_temperature),
                tint = themeColor.textColor.copy(alpha = if (themeColor == DayThemeColor) 0.6f else 0.87f),
                modifier = Modifier.padding(end = 4.dp)
            )

            Text(
                text = "${currentWeather?.maxTemperatureCelsius?.toInt()?.toString() ?: ""}$unit",
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                ),
                color = themeColor.textColor.copy(alpha = if (themeColor == DayThemeColor) 0.6f else 0.87f),
                modifier = Modifier.padding(end = 4.dp)
            )

            VerticalDivider(
                thickness = 1.dp,
                color = themeColor.textColor.copy(alpha = 0.24f),
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .height(14.dp)
                    .padding(end = 4.dp)
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_small_arrow_down),
                contentDescription = stringResource(R.string.lowest_temperature),
                tint = themeColor.textColor.copy(alpha = if (themeColor == DayThemeColor) 0.6f else 0.87f),
                modifier = Modifier.padding(end = 4.dp)
            )

            Text(
                text = "${currentWeather?.minTemperatureCelsius?.toInt()?.toString() ?: ""}$unit",
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                ),
                color = themeColor.textColor.copy(alpha = if (themeColor == DayThemeColor) 0.6f else 0.87f),
            )
        }
    }
}