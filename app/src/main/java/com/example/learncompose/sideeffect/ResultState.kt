package com.example.learncompose.sideeffect

sealed class ResultState {
    object Idle: ResultState()
    object StartingDataCalled: ResultState()
    object IncreaseDataCalled: ResultState()
    object Error: ResultState()
}