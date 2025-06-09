package com.thechance.myweather.presentation.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thechance.myweather.presentation.ui.theme.ThemeColor
import com.thechance.myweather.presentation.uiModels.WeatherMeasure

@Composable
fun CurrentWeatherMeasuresSection(
    modifier: Modifier = Modifier,
    measures: List<WeatherMeasure>,
    themeColor: ThemeColor
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (measures.size == 6) {
            repeat(2) { i ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    repeat(3) { j ->
                        val measure = measures[i * 3 + j]
                        CurrentWeatherMeasureCard(
                            image = measure.image,
                            value = measure.value,
                            unit = measure.unit.asString(),
                            measure = measure.measure.asString(),
                            theme = themeColor,
                            modifier = Modifier.weight(1f),
                        )
                    }
                }
            }
        }
    }

}