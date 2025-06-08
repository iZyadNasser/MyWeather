package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.model.Weather

class SortWeatherDataUseCase {

    operator fun invoke(weatherData: List<Weather>): List<Weather> {
        return weatherData.sortedBy { it.day }
    }
}