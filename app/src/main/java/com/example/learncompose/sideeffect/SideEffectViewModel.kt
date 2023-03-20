package com.example.learncompose.sideeffect

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SideEffectViewModel: ViewModel() {

    val state = mutableStateOf<ResultState>(ResultState.Idle)

    init {
        state.value = ResultState.Idle
    }

    fun getStartingDataFromApi(name: String) {
        Log.d(name, "getStartingDataFromApi: ")
        state.value = ResultState.StartingDataCalled
    }

    fun increaseCount(name: String) {
        Log.d(name, "increaseCount: ")
        state.value = ResultState.IncreaseDataCalled
    }
}