package com.example.kiparolessons.cleancodetest.domain.usecase

import com.example.kiparolessons.cleancodetest.domain.models.SaveUserNameParam
import com.example.kiparolessons.cleancodetest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean{
        return userRepository.saveName(saveParam = param)
    }
}