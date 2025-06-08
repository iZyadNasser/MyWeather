package com.thechance.myweather.domain.model

data class UserLocation(
    val cityName: String,
    val timeZone: String,
    val latitude: Double, // TODO: String?
    val longitude: Double // TODO: String?
)