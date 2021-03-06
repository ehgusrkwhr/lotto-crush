package com.kdh.lottocrush.di

import com.kdh.lottocrush.data.network.LottoInfoService
import com.kdh.lottocrush.data.network.RequestDebugInterceptor
import com.kdh.lottocrush.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRequestDebugInterceptor(): RequestDebugInterceptor {
        return RequestDebugInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
       val httpLoggingInterceptor = HttpLoggingInterceptor()
           .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("${BASE_URL}/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideLottoService(retrofit: Retrofit): LottoInfoService {
        return retrofit.create(LottoInfoService::class.java)
    }
}