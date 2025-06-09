package com.thechance.myweather.data.dataSource.dto

import kotlinx.serialization.Serializable


@Serializable
data class ErrorDto(
    val error: Boolean?,
    val reason: String?,
)