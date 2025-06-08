package com.thechance.myweather.data.di

import com.google.android.gms.location.LocationServices
import com.thechance.myweather.data.config.HttpClientFactory
import com.thechance.myweather.data.dataSource.LocationDataSourceImpl
import com.thechance.myweather.domain.dataSource.LocationDataSource
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
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

    single {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }

    single<LocationDataSource> {
        LocationDataSourceImpl(get(), get())
    }
}