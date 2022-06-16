package com.kdh.lottocrush.data.repository

import com.kdh.lottocrush.data.dto.LottoInfo
import com.kdh.lottocrush.data.network.LottoInfoService
import com.kdh.lottocrush.exceptions.NetworkFailureException
import com.kdh.lottocrush.ui.base.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LottoSearchRepositoryImpl @Inject constructor(
    private val api: LottoInfoService
) : LottoSearchRepository {

    override suspend fun searchLotto(count: Int): UiState<LottoInfo>? {
        return withContext(Dispatchers.IO){
            val response = api.fetchLottoInfo(count)
            if (response.isSuccessful) {
                response.body()?.let {
                    UiState.Success(it)
                }
            } else {
                UiState.Error("network Error")
            }
        }
    }


}