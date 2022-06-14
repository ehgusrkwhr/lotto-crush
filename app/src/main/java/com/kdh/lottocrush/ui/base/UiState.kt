package com.kdh.lottocrush.ui.base

sealed class UiState{
    object Loading : UiState()
    data class Success<T>(val data: T):UiState()
    data class Error(val error: Throwable?):UiState()

}