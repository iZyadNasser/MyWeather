package com.thechance.myweather.presentation.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.myweather.R
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.NightThemeColor
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.ui.theme.Urbanist
import com.thechance.myweather.presentation.utils.UiImage

@Composable
fun CurrentWeatherMeasureCard(
    image: UiImage,
    value: String,
    unit: String,
    measure: String,
    theme: ThemeColor,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (theme == DayThemeColor) {
        Color.White.copy(alpha = 0.7f)
    } else {
        theme.backgroundMainColor
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .width(108.dp)
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = theme.textColor.copy(alpha = 0.08f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(
                vertical = 16.dp,
                horizontal = 8.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = image.asResource()),
            contentDescription = measure,
            tint = theme.iconColor,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(32.dp)
        )

        Text(
            text = "$value $unit",
            color = theme.textColor.copy(alpha = 0.87f),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(bottom = 2.dp)
        )

        Text(
            text = measure,
            color = theme.textColor.copy(alpha = 0.6f),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(bottom = 2.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewCurrentWeatherMeasureCard() {
    CurrentWeatherMeasureCard(
        image = UiImage.Drawable(R.drawable.ic_fast_wind),
        value = "13",
        unit = "KM/h",
        measure = "Wind",
        theme = NightThemeColor
    )
}