package com.example.payany1.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitBuilder {


    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://digitaltestapp.ubl.com.pk/UBLNetBankingEncrypted/Service.asmx/")
    }

    @Singleton
    @Provides
    fun getService(retrofitBuilder: Builder): PaymentAPIServices {
        return retrofitBuilder.build().create(PaymentAPIServices::class.java)
    }
}