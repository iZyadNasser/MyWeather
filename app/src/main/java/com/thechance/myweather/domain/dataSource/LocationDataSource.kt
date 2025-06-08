package com.thechance.myweather.domain.dataSource

import android.location.Location

interface LocationDataSource {
    suspend fun getCurrentLocation(): Result<Location>
}