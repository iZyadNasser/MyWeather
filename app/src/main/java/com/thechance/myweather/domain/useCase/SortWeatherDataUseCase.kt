package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.dataSource.DayWeather
import com.thechance.myweather.domain.model.Weather

class SortWeatherDataUseCase {

    operator fun invoke(weatherData: List<DayWeather>): List<Weather> {
        TODO()
    }
}