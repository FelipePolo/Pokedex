package com.felipepolo.pokedex.data.remote

import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.utils.Resource
import java.util.ArrayList
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val webService: WebService
) {
    suspend fun getPokemonsByGeneration(id:String): Resource<ArrayList<Pokemon>> {
        val nameList =  webService.getPokemonNamesByGen(id).pokemon_species
        val pokemonList = ArrayList<Pokemon>()
        nameList?.forEach {
            val pokemon = webService.getPokemonByName(it.name.toString())
            pokemonList.add(pokemon)
        }
        return Resource.Success(pokemonList)
    }
}