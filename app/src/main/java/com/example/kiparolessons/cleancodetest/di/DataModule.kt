package com.example.kiparolessons.cleancodetest.di

import android.content.Context
import com.example.kiparolessons.cleancodetest.data.repository.UserRepositoryImpl
import com.example.kiparolessons.cleancodetest.data.storage.UserStorage
import com.example.kiparolessons.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.kiparolessons.cleancodetest.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}