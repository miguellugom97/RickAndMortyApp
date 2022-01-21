/*
 * *
 *  * Created by Miguel Lugo Moreno on 19/01/22 11:39
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19/01/22 11:39
 *
 */

package com.miguellugo.rickandmortyapp.ui.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.databinding.ActivityDetailBinding
import com.miguellugo.rickandmortyapp.ui.viewmodel.DetailViewModel
import com.miguellugo.rickandmortyapp.utils.extension.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var id: Int? = null
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        onBackPressedDispatcher.addCallback {
            finish()
        }

        id = intent.getIntExtra("id", 0)
        if (id != null)
            detailViewModel.getCharacterById(id!!)

        detailViewModel.isLoading.observe(this, {
            binding.progressBar.isVisible = it
        })

        detailViewModel.character.observe(this, { character ->
            setUI(character)
        })
    }

    private fun setUI(character: Character) {
        binding.apply {
            characterImageView.load(character.image)
            nameCharacterTextView.text = character.name
            statusSpecieTextView.text = ("${character.status} - ${character.species}")
            lastLocationTextView.text = character.location.name
            firstSeenInTextView.text = character.origin.name
            genderTextView.text = character.gender
        }
    }
}