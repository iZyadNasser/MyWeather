package com.thechance.myweather.presentation.di

import com.thechance.myweather.presentation.weather.InteractionHandler
import com.thechance.myweather.presentation.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::WeatherViewModel)

    single<InteractionHandler> {
        get<WeatherViewModel>()
    }
}