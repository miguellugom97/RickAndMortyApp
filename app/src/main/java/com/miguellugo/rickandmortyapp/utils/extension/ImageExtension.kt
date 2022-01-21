/*
 * *
 *  * Created by Miguel Lugo Moreno on 21/01/22 11:11
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 21/01/22 11:11
 *
 */

package com.miguellugo.rickandmortyapp.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(this.context).load(url).into(this)
}