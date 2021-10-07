package com.rickandmorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rickandmorty.data.model.Result
import com.rickandmorty.domain.usecase.CharacterUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class HomeViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    val characterMutableList = MutableLiveData<List<Result>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    init {
        getAllCharacter()
    }

    private fun getAllCharacter() = CoroutineScope(IO).launch {
        loading.postValue(true)
        try {
            characterUseCase.getAllCharacter().let {
                characterMutableList.postValue(characterUseCase.getAllCharacter().results)
                loading.postValue(false)
            }
        }catch (error: Throwable) {
            loading.postValue(false)
            handleError(error)
        }
    }

    private fun handleError(error: Throwable) {
        when(error) {
            is HttpException -> errorMessage.postValue(
                "Erro de conexão código ${error.code()}"
            )
            is UnknownHostException -> errorMessage.postValue(
                "verifique a sua conexão"
            )
        }
    }
}