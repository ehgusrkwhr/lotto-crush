package com.kdh.lottocrush.di

import com.kdh.lottocrush.data.repository.LottoSearchRepository
import com.kdh.lottocrush.data.repository.LottoSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLottoSearchRepository(
        lottoSearchRepositoryImpl: LottoSearchRepositoryImpl
    ):LottoSearchRepository

}