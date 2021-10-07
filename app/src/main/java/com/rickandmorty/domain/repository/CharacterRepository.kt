package com.rickandmorty.domain.repository

import com.rickandmorty.data.model.CharacterResponse

interface CharacterRepository {
    suspend fun getAllCharacter(): CharacterResponse
}