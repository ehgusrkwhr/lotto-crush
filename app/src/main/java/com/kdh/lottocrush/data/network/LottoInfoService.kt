package com.kdh.lottocrush.data.network

import com.kdh.lottocrush.data.dto.LottoInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LottoInfoService {

    @GET("common.do?method=getLottoNumber")
    suspend fun fetchLottoInfo(@Query("drwNo") drwNo: Int,): Response<LottoInfo>
}