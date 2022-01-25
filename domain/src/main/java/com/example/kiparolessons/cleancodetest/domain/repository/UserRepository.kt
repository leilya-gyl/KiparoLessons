package com.example.kiparolessons.cleancodetest.domain.repository

import com.example.kiparolessons.cleancodetest.domain.models.SaveUserNameParam
import com.example.kiparolessons.cleancodetest.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}