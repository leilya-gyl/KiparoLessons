package com.example.kiparolessons.cleancodetest.di

import android.content.Context
import com.example.kiparolessons.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.kiparolessons.cleancodetest.domain.usecase.SaveUserNameUseCase
import com.example.kiparolessons.cleancodetest.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() : Context {
        return context
    }
   // @Provides
   // fun provideMainViewModelFactory(
   //     getUserNameUseCase: GetUserNameUseCase,
   //     saveUserNameUseCase: SaveUserNameUseCase
   // ) : MainViewModelFactory {
   //     return MainViewModelFactory(
   //         getUserNameUseCase = getUserNameUseCase,
   //         saveUserNameUseCase = saveUserNameUseCase
   //     )
   // }
}