package com.thechance.myweather.domain.di

import com.thechance.myweather.domain.useCase.GetUserLocationUseCase
import com.thechance.myweather.domain.useCase.GetWeatherDataUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetWeatherDataUseCase)
    singleOf(::GetUserLocationUseCase)
}