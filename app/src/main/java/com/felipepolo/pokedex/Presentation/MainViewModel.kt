package com.felipepolo.pokedex.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.felipepolo.pokedex.domain.MainRepositoryInterface
import com.felipepolo.pokedex.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepositoryInterface: MainRepositoryInterface): ViewModel() {

    val msj = "hola mundo"

    fun getPokemonList(id:String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading)
        try {
            emit(mainRepositoryInterface.getPokemonsByGeneration(id))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}