package com.felipepolo.pokedex.data.remote

import android.util.Log
import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.utils.Resource
import java.lang.Exception
import java.util.ArrayList
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val webService: WebService
) {
    suspend fun getPokemonsByGeneration(id: String): Resource<ArrayList<Pokemon>> {
        val nameList = webService.getPokemonNamesByGen(id).pokemon_species
        val pokemonList = ArrayList<Pokemon>()
        nameList.forEach {
            try {
                val pokemon = webService.getPokemonByName(it.name)
                Log.d("Pokemon", "getPokemonsByGeneration: ${pokemon} ")
                pokemonList.add(pokemon)
            } catch (e: Exception) {
            }
        }
        return Resource.Success(pokemonList)
    }

    suspend fun getRandomPokemon(): Resource<Pokemon> {
        return Resource.Success(
            webService.getPokemonById((1..800).random().toString())
        )
    }
}