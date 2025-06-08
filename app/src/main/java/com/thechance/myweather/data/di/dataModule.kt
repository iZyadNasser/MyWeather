package com.thechance.myweather.data.di

import com.thechance.myweather.data.config.HttpClientFactory
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val dataModule = module {
    single {
        runBlocking {
            HttpClientFactory.create(
                OkHttp.create {
                    preconfigured = OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                        )
                        .build()
                }
            )
        }
    }
}