package com.thechance.myweather.data.utils

import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        return Result.failure(e)
    } catch (e: SerializationException) {
        return Result.failure(e)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.failure(e)
    }

    return responseToResult(response)
}