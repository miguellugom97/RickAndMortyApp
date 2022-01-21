/*
 * *
 *  * Created by Miguel Lugo Moreno on 19/01/22 11:30
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19/01/22 11:30
 *
 */

package com.miguellugo.rickandmortyapp.domain

import com.miguellugo.rickandmortyapp.data.model.Result
import com.miguellugo.rickandmortyapp.data.network.ResultRepository
import javax.inject.Inject

class GetCharacterByPage @Inject constructor(private val repository: ResultRepository) {
    suspend fun getCharacters(page: Int): Result? = repository.getAllCharactersByPage(page)
}