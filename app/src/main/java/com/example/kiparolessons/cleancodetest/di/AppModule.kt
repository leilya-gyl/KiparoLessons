package com.example.kiparolessons.cleancodetest.di

import com.example.kiparolessons.cleancodetest.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>{
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }
}