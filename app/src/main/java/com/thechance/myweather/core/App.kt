package com.thechance.myweather.core

import android.app.Application
import com.thechance.myweather.data.di.dataModule
import com.thechance.myweather.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                domainModule,
                dataModule
            )
        }
    }
}