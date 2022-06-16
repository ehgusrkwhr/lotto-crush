package com.kdh.lottocrush.ui.base

sealed class UiState<out T : Any>{

    data class Success<T : Any>(val data: T):UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
    object Loading : UiState<Nothing>()

}