package com.thechance.myweather.presentation.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thechance.myweather.domain.useCase.GetUserLocationUseCase
import com.thechance.myweather.domain.useCase.GetWeatherDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getUserLocationUseCase: GetUserLocationUseCase,
    private val getWeatherUseCase: GetWeatherDataUseCase
): ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getWeatherUseCase(
                lat = 32.109333,
                lon = 34.855499
            )
                .onSuccess { response ->
                    Log.e("TAG", "$response ", )
                }
        }


    }

    fun getUserLocation() {
        viewModelScope.launch {
            Log.e("TAG", "${state.value.location?.cityName}: ", )
            Log.e("TAG", "${state.value.location?.longitude}: ", )
            Log.e("TAG", "${state.value.location?.latitude}: ", )
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
            Log.e("TAG", "${state.value.location?.cityName}: ", )
            Log.e("TAG", "${state.value.location?.longitude}: ", )
            Log.e("TAG", "${state.value.location?.latitude}: ", )
            toggleLoading()
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
        Log.e("TAG", "handleError: ", )
    }
}