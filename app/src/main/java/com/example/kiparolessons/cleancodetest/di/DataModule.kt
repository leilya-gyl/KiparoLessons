package com.example.kiparolessons.cleancodetest.di

import com.example.kiparolessons.cleancodetest.data.repository.UserRepositoryImpl
import com.example.kiparolessons.cleancodetest.data.storage.UserStorage
import com.example.kiparolessons.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.kiparolessons.cleancodetest.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}