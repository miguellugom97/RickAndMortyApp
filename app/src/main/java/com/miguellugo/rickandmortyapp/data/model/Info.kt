/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:08
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:08
 *
 */

package com.miguellugo.rickandmortyapp.data.model

data class Info(
    val count: Int,
    val next: String? = null,
    val pages: Int,
    val prev: String? = null
)