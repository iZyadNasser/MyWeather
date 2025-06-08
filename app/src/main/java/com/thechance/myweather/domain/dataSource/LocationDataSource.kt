package com.thechance.myweather.domain.dataSource

import com.thechance.myweather.domain.model.UserLocation

interface LocationDataSource {
    suspend fun getCurrentLocation(): Result<UserLocation>
}