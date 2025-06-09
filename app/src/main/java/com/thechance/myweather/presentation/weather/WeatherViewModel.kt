package com.thechance.myweather.presentation.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thechance.myweather.core.utils.getCurrentSystemDateTime
import com.thechance.myweather.domain.model.Weather
import com.thechance.myweather.domain.useCase.GetUserLocationUseCase
import com.thechance.myweather.domain.useCase.GetWeatherDataUseCase
import com.thechance.myweather.domain.useCase.WeatherDataHandler
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
                            location = response
                        )
                    }
                }
                .onFailure {
                    handleError(it)
                }

            loadWeatherData()
            Log.e("TEST", "${state.value.currentWeather}", )
            Log.e("TEST", "${state.value.hourlyWeather}", )
            Log.e("TEST", "${state.value.dailyWeather}", )
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
        val weatherDataHandler = WeatherDataHandler.setupWeatherFormatter(
            weatherList = response,
            time = getCurrentSystemDateTime()
        )

        _state.update {
            it.copy(
                currentWeather = weatherDataHandler.getCurrentWeather(),
                hourlyWeather = weatherDataHandler.getNext24HoursHourlyWeather(),
                dailyWeather = weatherDataHandler.getNext7DaysDailyWeather()
            )
        }
    }

    private fun toggleLoading() {
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