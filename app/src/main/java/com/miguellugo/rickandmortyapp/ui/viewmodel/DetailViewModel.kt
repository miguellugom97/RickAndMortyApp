/*
 * *
 *  * Created by Miguel Lugo Moreno on 19/01/22 11:52
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19/01/22 11:52
 *
 */

package com.miguellugo.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.domain.GetCharacterById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterById: GetCharacterById
): ViewModel() {
    val character = MutableLiveData<Character>()
    val isLoading = MutableLiveData<Boolean>()

    fun getCharacterById(id: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharacterById.getCharacter(id)
            if (result != null) {
                character.postValue(result)
            }
            isLoading.postValue(false)
        }
    }
}