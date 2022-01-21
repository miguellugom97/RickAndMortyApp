/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 15:43
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 13/01/22 15:43
 *
 */

package com.miguellugo.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.data.model.Result
import com.miguellugo.rickandmortyapp.domain.GetCharacterById
import com.miguellugo.rickandmortyapp.domain.GetCharacterByPage
import com.miguellugo.rickandmortyapp.domain.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharacters: GetCharacters,
    private val getCharacterByPage: GetCharacterByPage
): ViewModel() {
    val resultModel = MutableLiveData<Result>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharacters()
            if (result != null) {
                resultModel.postValue(result)
            }
            isLoading.postValue(false)
        }
    }

    fun getCharactersByPage(page: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCharacterByPage.getCharacters(page)
            if (result != null) {
                resultModel.postValue(result)
            }
            isLoading.postValue(false)
        }
    }
}