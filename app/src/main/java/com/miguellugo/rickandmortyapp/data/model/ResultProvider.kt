/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:30
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 16:30
 *
 */

package com.miguellugo.rickandmortyapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultProvider @Inject constructor() {
    var result : Result? = null
}