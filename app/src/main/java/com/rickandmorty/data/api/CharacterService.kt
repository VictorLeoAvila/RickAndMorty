package com.rickandmorty.data.api

import com.rickandmorty.data.model.CharacterResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    suspend fun getAllCharacter(): CharacterResponse
}