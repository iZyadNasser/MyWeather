package com.thechance.myweather.presentation.utils

import com.thechance.myweather.R
import com.thechance.myweather.data.exceptions.ApiException
import com.thechance.myweather.data.exceptions.RequestTimeoutException
import com.thechance.myweather.data.exceptions.ServerException
import com.thechance.myweather.data.exceptions.TooManyRequestsException
import com.thechance.myweather.data.exceptions.UnauthorizedException
import com.thechance.myweather.data.exceptions.UnknownException

fun handleError(throwable: Throwable): UiText {
    return if (throwable is Exception) {
        when (throwable) {
            is UnknownException -> UiText.StringResource(R.string.unkown_error_happend)
            is ServerException -> UiText.StringResource(R.string.server_error)
            is ApiException -> {
                when (throwable) {
                    is RequestTimeoutException -> UiText.StringResource(R.string.request_timeout_error)
                    is TooManyRequestsException -> UiText.StringResource(R.string.too_many_requests_error)
                    else -> UiText.StringResource(R.string.unkown_error_happend)
                }
            }
            is SecurityException -> UiText.StringResource(R.string.location_permission_error)
            is UnauthorizedException -> UiText.StringResource(R.string.unauthorized_error)
            else -> UiText.StringResource(R.string.unkown_error_happend)
        }
    } else {
        UiText.StringResource(R.string.unkown_error_happend)
    }
}