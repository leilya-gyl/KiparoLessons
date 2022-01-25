package com.example.kiparolessons.cleancodetest.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kiparolessons.cleancodetest.data.repository.UserRepositoryImpl
import com.example.kiparolessons.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.kiparolessons.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.kiparolessons.cleancodetest.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
): ViewModelProvider.Factory {

    ///(LazyThreadSafetyMode.NONE) - пишем для того, чтобы указать что нам не нужна многопоточнось
    // по умолчанию 'by lazy' синхронизирован
/*
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

 */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}