/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:23
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:23
 *
 */

package com.miguellugo.rickandmortyapp.di

import com.miguellugo.rickandmortyapp.data.network.ResultApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideResultApiClient(retrofit: Retrofit): ResultApiClient {
        return retrofit.create(ResultApiClient::class.java)
    }
}