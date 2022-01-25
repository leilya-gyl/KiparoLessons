package com.example.kiparolessons.cleancodetest.di

import com.example.kiparolessons.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.kiparolessons.cleancodetest.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}