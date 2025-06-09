package com.thechance.myweather.data.utils

import com.thechance.myweather.data.dataSource.dto.ErrorDto
import com.thechance.myweather.data.exceptions.RequestTimeoutException
import com.thechance.myweather.data.exceptions.ServerException
import com.thechance.myweather.data.exceptions.TooManyRequestsException
import com.thechance.myweather.data.exceptions.UnauthorizedException
import com.thechance.myweather.data.exceptions.UnknownException
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                Result.success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.failure(e)
            }
        }
        /*TODO(Add more cases)*/
        401 -> Result.failure(UnauthorizedException(response.body<ErrorDto>().reason ?: ""))
        408 -> Result.failure(RequestTimeoutException(response.body<ErrorDto>().reason ?: ""))
        429 -> Result.failure(TooManyRequestsException(response.body<ErrorDto>().reason ?: ""))
        in 500..599 -> Result.failure(ServerException(response.body<ErrorDto>().reason ?: ""))
        else -> Result.failure(UnknownException(response.body<ErrorDto>().reason ?: ""))
    }
}