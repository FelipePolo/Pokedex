package com.felipepolo.pokedex.domain

import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.data.model.PokemonEntity
import com.felipepolo.pokedex.data.model.PokemonNames
import com.felipepolo.pokedex.utils.Resource

interface MainRepositoryInterface {
    suspend fun getPokemonsByGeneration(id:String): Resource<List<Pokemon>>
    suspend fun getRandomPokemon(): Resource<Pokemon>
    suspend fun saveFavoritePokemon(pokemon: Pokemon)
    suspend fun getAllFavoritePokemon(): Resource<List<PokemonEntity>>
    suspend fun deleteFavoritePokemon(pokemonEntity: PokemonEntity)
}