/*
 * *
 *  * Created by Miguel Lugo Moreno on 19/01/22 11:33
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19/01/22 11:33
 *
 */

package com.miguellugo.rickandmortyapp.domain

import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.data.network.ResultRepository
import javax.inject.Inject

class GetCharacterById @Inject constructor(private val repository: ResultRepository) {
    suspend fun getCharacter(id: Int) : Character? = repository.getCharacterById(id)
}