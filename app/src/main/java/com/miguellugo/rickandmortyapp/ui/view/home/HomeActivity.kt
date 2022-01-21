/*
 * *
 *  * Created by Miguel Lugo Moreno on 19/01/22 11:13
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19/01/22 11:05
 *
 */
package com.miguellugo.rickandmortyapp.ui.view.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguellugo.rickandmortyapp.data.model.Character
import com.miguellugo.rickandmortyapp.databinding.ActivityHomeBinding
import com.miguellugo.rickandmortyapp.ui.view.detail.DetailActivity
import com.miguellugo.rickandmortyapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), ListCharacterAdapter.OnItemClickListener {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var characterAdapter: ListCharacterAdapter
    private var page: Int = 1
    private var totalPages = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        homeViewModel.onCreate()
        initRecycler()
        homeViewModel.isLoading.observe(this, {
            binding.progressBar.isVisible = it
        })

        homeViewModel.resultModel.observe(this, { result ->
            val characters = result.characters
            totalPages = result.info.pages
            binding.currentPageTextView.text = ("$page - $totalPages")
            characterAdapter.setData(characters)

            binding.nextButton.setOnClickListener {
                if (result.info.next != null && page < totalPages)
                    goToNextPage()
            }

            binding.prevButton.setOnClickListener {
                if (result.info.prev != null && page > 1)
                    goToPreviousPage()
            }
        })
    }

    private fun goToNextPage() {
        page += 1
        homeViewModel.getCharactersByPage(page)
    }

    private fun goToPreviousPage() {
        page -= 1
        homeViewModel.getCharactersByPage(page)
    }

    private fun initRecycler() {
        characterAdapter = ListCharacterAdapter(this)
        binding.apply {
            charactersRecyclerView.adapter = characterAdapter
            charactersRecyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
            charactersRecyclerView.isNestedScrollingEnabled = false
        }
    }

    override fun onClickCharacter(character: Character) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", character.id)
        startActivity(intent)
    }
}