package com.example.kiparolessons.cleancodetest.di

import com.example.kiparolessons.cleancodetest.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}