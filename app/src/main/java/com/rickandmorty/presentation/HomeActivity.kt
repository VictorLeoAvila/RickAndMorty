package com.rickandmorty.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.rickandmorty.R
import com.rickandmorty.data.model.Result
import com.rickandmorty.databinding.HomeActivityBinding
import com.rickandmorty.domain.usecase.CharacterUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()

    private lateinit var binding: HomeActivityBinding
    private val results = mutableListOf<Result>()
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        characterAdapter = CharacterAdapter(this, results)
        binding.homeList.adapter = characterAdapter
        binding.homeList.layoutManager = GridLayoutManager(this, 2)
        setupViewModel()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupViewModel() {
        viewModel.characterMutableList.observe(this, Observer {
            it.let { itChar ->
                results.addAll(itChar)
            }
            characterAdapter.notifyDataSetChanged()
        })

        viewModel.loading.observe(this, Observer {
            if(it) {
                binding.progressHome.visibility = VISIBLE
            } else {
                binding.progressHome.visibility = GONE
            }
        })

        viewModel.errorMessage.observe(this, Observer {
            it.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }
}