package com.kdh.lottocrush.data.repository

import com.kdh.lottocrush.data.dto.LottoInfo
import retrofit2.Response

interface LottoSearchRepository {

    suspend fun searchLotto(
        count : Int
    ) : Response<LottoInfo>

}