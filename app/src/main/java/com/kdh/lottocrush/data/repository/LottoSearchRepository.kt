package com.kdh.lottocrush.data.repository

import com.kdh.lottocrush.data.dto.LottoInfo
import com.kdh.lottocrush.ui.base.UiState
import retrofit2.Response

interface LottoSearchRepository {

    suspend fun searchLotto(count : Int) : UiState<LottoInfo>?
}