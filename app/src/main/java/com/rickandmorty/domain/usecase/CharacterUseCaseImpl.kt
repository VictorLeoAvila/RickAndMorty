package com.rickandmorty.domain.usecase

import com.rickandmorty.data.model.CharacterResponse
import com.rickandmorty.domain.repository.CharacterRepository

class CharacterUseCaseImpl(
    private val characterRepository: CharacterRepository
): CharacterUseCase {
    override suspend fun getAllCharacter(): CharacterResponse {
        return characterRepository.getAllCharacter()
    }
}