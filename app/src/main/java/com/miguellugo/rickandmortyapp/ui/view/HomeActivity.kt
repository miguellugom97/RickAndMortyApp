/*
 * *
 *  * Created by Miguel Lugo Moreno on 13/01/22 16:20
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/01/22 18:50
 *
 */
package com.miguellugo.rickandmortyapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.miguellugo.rickandmortyapp.databinding.ActivityHomeBinding
import com.miguellugo.rickandmortyapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        homeViewModel.onCreate()

        homeViewModel.resultModel.observe(this, { result ->
            Toast.makeText(this, "${result.info.count}", Toast.LENGTH_SHORT).show()
        })
    }
}