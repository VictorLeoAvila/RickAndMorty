package com.rickandmorty.domain.usecase

import com.rickandmorty.data.model.CharacterResponse

interface CharacterUseCase {
    suspend fun getAllCharacter(): CharacterResponse
}