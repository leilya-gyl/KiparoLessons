package com.example.kiparolessons.cleancodetest.app

import android.app.Application
import com.example.kiparolessons.cleancodetest.di.AppComponent
import com.example.kiparolessons.cleancodetest.di.AppModule
import com.example.kiparolessons.cleancodetest.di.DaggerAppComponent
import dagger.Component

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}