package com.thechance.myweather.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.myweather.R
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.ui.theme.Urbanist
import com.thechance.myweather.presentation.utils.UiImage
import com.thechance.myweather.presentation.utils.formatWeekDay

@Composable
fun DailyWeatherRow(
    weekDay: String,
    image: UiImage,
    weatherDescription: String,
    maxTemperature: String,
    minTemperature: String,
    unit: String,
    themeColor: ThemeColor,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = weekDay.formatWeekDay(),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
            ),
            color = themeColor.textColor.copy(alpha = 0.6f),
            modifier = Modifier.weight(2f)
        )

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image.asPainter(),
                contentDescription = weatherDescription,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(32.dp)
            )
        }

        Row(
            modifier = Modifier.weight(2f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_small_arrow_up),
                contentDescription = stringResource(R.string.highest_temperature),
                tint = themeColor.textColor.copy(alpha = 0.87f),
                modifier = Modifier.padding(end = 4.dp)
            )

            Text(
                text = "$maxTemperature$unit",
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                ),
                color = themeColor.textColor.copy(alpha = 0.87f),
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
                tint = themeColor.textColor.copy(alpha = 0.87f),
                modifier = Modifier.padding(end = 4.dp)
            )

            Text(
                text = "$minTemperature$unit",
                style = TextStyle(
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                ),
                color = themeColor.textColor.copy(alpha = 0.87f),
            )
        }
    }
}