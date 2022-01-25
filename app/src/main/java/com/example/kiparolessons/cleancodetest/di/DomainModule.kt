package com.example.kiparolessons.cleancodetest.di

import com.example.kiparolessons.cleancodetest.domain.repository.UserRepository
import com.example.kiparolessons.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.kiparolessons.cleancodetest.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule{
    @Provides
    fun provideGetUserNameUseCase(userRepository : UserRepository) : GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository : UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}