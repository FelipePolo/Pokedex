package com.felipepolo.pokedex.Presentation

import android.util.Log
import androidx.lifecycle.*
import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.domain.MainRepositoryInterface
import com.felipepolo.pokedex.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepositoryInterface: MainRepositoryInterface) :
    ViewModel() {

    private var pokemonList:Resource<List<Pokemon>>? = null

    private var _pokemon: MutableLiveData<Resource<Pokemon>> = MutableLiveData()
    val pokemon: LiveData<Resource<Pokemon>> = _pokemon

    init {
        getRandomPokemon()
    }

    fun getPokemonList(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading)
        try {
            if(pokemonList == null){
                pokemonList = mainRepositoryInterface.getPokemonsByGeneration(id)
            }
            emit(pokemonList)
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun getRandomPokemon() = viewModelScope.launch{
        _pokemon.value = Resource.Loading
        try {
           _pokemon.value = mainRepositoryInterface.getRandomPokemon()
        }catch (e:Exception){
            _pokemon.value = Resource.Failure(e)
        }
    }

    fun saveFavoritePokemon() {
        viewModelScope.launch {
            // Arreglar Problema de casteo, probablemente toque implementar un pokemon en lugar de resource<Pokemon>, o ver alguna manera de hacer esperar al usuario hasta que
            //resource.loading cambie a resource.success(pokemon) y no de errores de casteo.
            mainRepositoryInterface.saveFavoritePokemon((pokemon.value as Resource.Success).data)
        }
    }
}