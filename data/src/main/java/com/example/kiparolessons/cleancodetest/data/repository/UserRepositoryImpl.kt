package com.example.kiparolessons.cleancodetest.data.repository

import com.example.kiparolessons.cleancodetest.data.storage.models.User
import com.example.kiparolessons.cleancodetest.data.storage.UserStorage
import com.example.kiparolessons.cleancodetest.domain.repository.UserRepository
import com.example.kiparolessons.cleancodetest.domain.models.SaveUserNameParam
import com.example.kiparolessons.cleancodetest.domain.models.UserName


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean{
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName():UserName{
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}