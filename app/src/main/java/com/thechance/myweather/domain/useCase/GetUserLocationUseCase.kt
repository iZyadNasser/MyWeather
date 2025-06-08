package com.thechance.myweather.domain.useCase

import com.thechance.myweather.domain.dataSource.LocationDataSource
import com.thechance.myweather.domain.model.UserLocation

class GetUserLocationUseCase(
    private val locationDataSource: LocationDataSource
) {

    suspend fun invoke(): Result<UserLocation> {
        return locationDataSource.getCurrentLocation()
    }
}