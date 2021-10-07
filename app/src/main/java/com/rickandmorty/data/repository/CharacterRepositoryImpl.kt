package com.rickandmorty.data.repository

import com.rickandmorty.data.dataSource.CharacterDataSource
import com.rickandmorty.data.model.CharacterResponse
import com.rickandmorty.domain.model.Character
import com.rickandmorty.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterDataSource: CharacterDataSource
): CharacterRepository {
    override suspend fun getAllCharacter(): CharacterResponse {
        return characterDataSource.characterManagement()
    }
}