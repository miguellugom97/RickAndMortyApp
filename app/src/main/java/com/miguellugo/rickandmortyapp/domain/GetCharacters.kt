/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:42
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:42
 *
 */

package com.miguellugo.rickandmortyapp.domain

import com.miguellugo.rickandmortyapp.data.model.Result
import com.miguellugo.rickandmortyapp.data.network.ResultRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(private val repository: ResultRepository){
    suspend operator fun invoke(): Result? = repository.getAllCharacters()
}