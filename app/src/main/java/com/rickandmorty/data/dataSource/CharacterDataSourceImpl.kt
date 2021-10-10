package com.rickandmorty.data.dataSource

import com.rickandmorty.data.api.CharacterService
import com.rickandmorty.data.model.CharacterResponse
import com.rickandmorty.domain.utils.BASE_URL

class CharacterDataSourceImpl(
    private val characterService: CharacterService
): CharacterDataSource {
    override suspend fun characterManagement(): CharacterResponse {
        return characterService.getAllCharacter()
    }
}