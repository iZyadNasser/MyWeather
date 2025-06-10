package com.thechance.myweather.presentation.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thechance.myweather.core.utils.getCurrentSystemDateTime
import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.domain.useCase.GetUserLocationUseCase
import com.thechance.myweather.domain.useCase.GetWeatherDataUseCase
import com.thechance.myweather.domain.useCase.WeatherDataHandler
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.ui.theme.NightThemeColor
import com.thechance.myweather.presentation.uiModels.CurrentWeather
import com.thechance.myweather.presentation.uiModels.DailyWeather
import com.thechance.myweather.presentation.uiModels.HourlyWeather
import com.thechance.myweather.presentation.uiModels.TimeTheme
import com.thechance.myweather.presentation.uiModels.mapper.toCurrentWeather
import com.thechance.myweather.presentation.uiModels.mapper.toDailyWeather
import com.thechance.myweather.presentation.uiModels.mapper.toHourlyWeather
import com.thechance.myweather.presentation.utils.formatCityName
import com.thechance.myweather.presentation.utils.getCurrentWeatherMeasures
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getUserLocationUseCase: GetUserLocationUseCase,
    private val getWeatherUseCase: GetWeatherDataUseCase
) : ViewModel(), WeatherInteractionHandler {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    override fun getLocationAndLoadWeather() {
        viewModelScope.launch {
            toggleLoading()
            getUserLocationUseCase()
                .onSuccess { response ->
                    _state.update {
                        it.copy(
                            location = response.copy(
                                cityName = response.cityName?.formatCityName()
                            )
                        )
                    }
                }
                .onFailure {
                    handleError(it)
                }

            loadWeatherData()
            toggleLoading()
        }

    }

    private suspend fun loadWeatherData() {
        getWeatherUseCase(
            lat = state.value.location?.latitude ?: 0.0,
            lon = state.value.location?.longitude ?: 0.0
        ).onSuccess { response ->
            parseAndSaveWeatherData(response)
        }.onFailure {
            handleError(it)
        }
    }

    private fun parseAndSaveWeatherData(response: List<Weather>) {
        _state.update {
            it.copy(
                currentWeather = getCurrentWeather(response),
                hourlyWeather = getHourlyWeather(response),
                dailyWeather = getDailyWeather(response),
            )
        }

        _state.update {
            it.copy(
                timeTheme = getTimeTheme(it.currentWeather?.isDay != false)
            )
        }

        _state.update {
            it.copy(
                themeColor = if (it.timeTheme == TimeTheme.DAY) {
                    DayThemeColor
                } else {
                    NightThemeColor
                }
            )
        }

        _state.update {
            it.copy(
                currentWeatherMeasures = getCurrentWeatherMeasures(state.value.currentWeather)
            )
        }
    }

    private fun getCurrentWeather(weatherList: List<Weather>): CurrentWeather {
        val weatherDataHandler = WeatherDataHandler.setupWeatherFormatter(
            weatherList = weatherList,
            time = getCurrentSystemDateTime()
        )

        return weatherDataHandler
            .getCurrentWeather()
            .let {
                it.toCurrentWeather(
                    maxTemperatureCelsius = weatherDataHandler.getHighestTemperatureOfDate(it.time.date).temperatureCelsius,
                    minTemperatureCelsius = weatherDataHandler.getLowestTemperatureOfDate(it.time.date).temperatureCelsius
                )
            }
    }

    private fun getHourlyWeather(weatherList: List<Weather>): List<HourlyWeather> {
        val weatherDataHandler = WeatherDataHandler.setupWeatherFormatter(
            weatherList = weatherList,
            time = getCurrentSystemDateTime()
        )

        return weatherDataHandler
            .getNext24HoursHourlyWeather()
            .map { it.toHourlyWeather() }
    }

    private fun getDailyWeather(weatherList: List<Weather>): List<DailyWeather> {
        val weatherDataHandler = WeatherDataHandler.setupWeatherFormatter(
            weatherList = weatherList,
            time = getCurrentSystemDateTime()
        )

        return weatherDataHandler
            .getNext7DaysDailyWeather()
            .chunked(24)
            .map {
                it.toDailyWeather()
            }
    }

    private fun getTimeTheme(isDay: Boolean): TimeTheme {
        return if (isDay) {
            TimeTheme.DAY
        } else {
            TimeTheme.NIGHT
        }
    }

    fun toggleLoading() {
        _state.update {
            it.copy(
                isLoading = !it.isLoading
            )
        }
    }

    private fun handleError(throwable: Throwable) {
        Log.e("TAG", "handleError: ")
        /*TODO*/
    }
}