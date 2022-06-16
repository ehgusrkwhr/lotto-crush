package com.kdh.lottocrush.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdh.lottocrush.data.dto.LottoInfo
import com.kdh.lottocrush.data.repository.LottoSearchRepository
import com.kdh.lottocrush.ui.base.UiState
import com.kdh.lottocrush.util.LottoUtil.getNextEpisodeBasedonDate
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LottoViewModel @Inject constructor(private val lottoSearchRepository: LottoSearchRepository) :
    ViewModel() {

        private var _lottoNum : MutableLiveData<LottoInfo> = MutableLiveData()
        val lottoNum : LiveData<LottoInfo> get() = _lottoNum
        private val lastLottoNum : Int = getNextEpisodeBasedonDate()
         fun searchLastLottoInfo()  = viewModelScope.launch {
             when(val lastInfo = lottoSearchRepository.searchLotto(lastLottoNum)){
                is UiState.Success -> {
                    _lottoNum.value = lastInfo.data
                }
                else -> false
            }
        }
//    val uiState: StateFlow<UiState> = lottoSearchRepository.searchLotto().stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000L),
//        initialValue = UiState.Loading)
//    }


}