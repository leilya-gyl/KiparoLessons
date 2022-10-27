package com.example.kiparolessons.cleancodetest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kiparolessons.cleancodetest.domain.models.SaveUserNameParam
import com.example.kiparolessons.cleancodetest.domain.models.UserName
import com.example.kiparolessons.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.kiparolessons.cleancodetest.domain.usecase.SaveUserNameUseCase
import com.example.kiparolessons.cleancodetest.presentation.LoadEvent
import com.example.kiparolessons.cleancodetest.presentation.MainEvent
import com.example.kiparolessons.cleancodetest.presentation.MainState
import com.example.kiparolessons.cleancodetest.presentation.SaveEvent

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var stateLiveMutable = MutableLiveData<MainState>()
    val stateLive: LiveData<MainState> = stateLiveMutable

    init {
        Log.e("AAA", "VM created")
        stateLiveMutable.value = MainState(saveResult = false, firstName = "", lastName = "")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun send(event: MainEvent){
        when(event) {
            is SaveEvent -> {
                save(text = event.text)
            }
            is LoadEvent -> {
                load()
            }
        }
    }

    private fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        stateLiveMutable.value = MainState(
            saveResult = resultData,
            firstName = stateLiveMutable.value!!.firstName,
            lastName = stateLiveMutable.value!!.lastName
        )
    }

    private fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        stateLiveMutable.value = MainState(
            saveResult = stateLiveMutable.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }
}