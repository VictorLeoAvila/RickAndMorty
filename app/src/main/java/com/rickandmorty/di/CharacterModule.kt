package com.rickandmorty.di

import com.rickandmorty.data.api.CharacterService
import com.rickandmorty.data.api.HttpClient
import com.rickandmorty.data.dataSource.CharacterDataSource
import com.rickandmorty.data.dataSource.CharacterDataSourceImpl
import com.rickandmorty.data.repository.CharacterRepositoryImpl
import com.rickandmorty.domain.repository.CharacterRepository
import com.rickandmorty.domain.usecase.CharacterUseCase
import com.rickandmorty.domain.usecase.CharacterUseCaseImpl
import com.rickandmorty.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal object CharacterModule {

    val characterModule = module {
        factory<CharacterDataSource> {
            CharacterDataSourceImpl(
                characterService = HttpClient().create(CharacterService::class)
            )
        }
        factory<CharacterRepository> {
            CharacterRepositoryImpl(
                characterDataSource = get()
            )
        }
        factory<CharacterUseCase> {
            CharacterUseCaseImpl(
                characterRepository = get()
            )
        }

        viewModel {
            HomeViewModel(
                characterUseCase = get()
            )
        }
    }
}