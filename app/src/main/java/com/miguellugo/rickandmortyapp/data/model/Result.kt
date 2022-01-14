/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:08
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:08
 *
 */

package com.miguellugo.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)