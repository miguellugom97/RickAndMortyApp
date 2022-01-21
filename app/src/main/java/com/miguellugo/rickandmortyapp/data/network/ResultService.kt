/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:37
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:37
 *
 */

package com.miguellugo.rickandmortyapp.data.network

import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ResultService @Inject constructor(private val api: ResultApiClient) {

    suspend fun getCharacters(): Result? {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters()
            response.body()
        }
    }

    suspend fun getCharactersByPage(page: Int): Result? {
        return withContext(Dispatchers.IO) {
            val response = api.getCharactersByPage(page)
            response.body()
        }
    }

    suspend fun getCharacterById(id: Int): Character? {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacterById(id)
            response.body()
        }
    }
}