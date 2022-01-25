package com.example.kiparolessons.cleancodetest.data.storage

import com.example.kiparolessons.cleancodetest.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}