/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:39
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:39
 *
 */

package com.miguellugo.rickandmortyapp.data.network

import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.data.model.Result
import com.miguellugo.rickandmortyapp.data.model.ResultProvider
import javax.inject.Inject

class ResultRepository @Inject constructor(private val api: ResultService, private val resultProvider: ResultProvider) {
    suspend fun getAllCharacters(): Result? {
        val response = api.getCharacters()
        resultProvider.result = response
        return response
    }

    suspend fun getAllCharactersByPage(page: Int): Result? {
        val response = api.getCharactersByPage(page)
        resultProvider.result = response
        return response
    }

    suspend fun getCharacterById(id: Int): Character? {
        return api.getCharacterById(id)
    }
}