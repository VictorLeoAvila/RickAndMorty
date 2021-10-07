package com.rickandmorty.data.dataSource

import com.rickandmorty.data.model.CharacterResponse

interface CharacterDataSource {
    suspend fun characterManagement(): CharacterResponse
}