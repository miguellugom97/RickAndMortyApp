/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:33
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:33
 *
 */

package com.miguellugo.rickandmortyapp.data.network

import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.data.model.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ResultApiClient {
    @GET("character/")
    suspend fun getCharacters(): Response<Result>

    @GET("character/")
    suspend fun getCharactersByPage(@Query("page") page: Int): Response<Result>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<Character>
}