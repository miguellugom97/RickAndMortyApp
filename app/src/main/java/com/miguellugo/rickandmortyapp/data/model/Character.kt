/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:08
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:08
 *
 */

package com.miguellugo.rickandmortyapp.data.model

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)