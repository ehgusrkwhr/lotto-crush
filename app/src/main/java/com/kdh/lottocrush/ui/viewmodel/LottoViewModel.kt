package com.kdh.lottocrush.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdh.lottocrush.data.repository.LottoSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LottoViewModel @Inject constructor(private val lottoSearchRepository: LottoSearchRepository) : ViewModel() {

    //api
    fun searchLottoInfo(count : Int){
        viewModelScope.launch(Dispatchers.Default){
            lottoSearchRepository.searchLotto(count)
        }
    }
}