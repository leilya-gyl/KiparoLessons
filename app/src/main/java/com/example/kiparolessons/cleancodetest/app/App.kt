package com.example.kiparolessons.cleancodetest.app

import android.app.Application
import com.example.kiparolessons.cleancodetest.di.appModule
import com.example.kiparolessons.cleancodetest.di.dataModule
import com.example.kiparolessons.cleancodetest.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}