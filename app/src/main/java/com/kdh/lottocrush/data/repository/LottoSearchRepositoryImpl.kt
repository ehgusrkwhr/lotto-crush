package com.kdh.lottocrush.data.repository

import com.kdh.lottocrush.data.dto.LottoInfo
import com.kdh.lottocrush.data.network.LottoInfoService
import com.kdh.lottocrush.exceptions.NetworkFailureException
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LottoSearchRepositoryImpl @Inject constructor(
    private val api : LottoInfoService
) : LottoSearchRepository {

    override suspend fun searchLotto(count: Int): Response<LottoInfo> {
        val response = api.fetchLottoInfo(count)
        if(response.isSuccessful){

        }else{
            throw NetworkFailureException("[${response.code()} - ${response.raw()}]")
        }

        return api.fetchLottoInfo(count)
    }

}