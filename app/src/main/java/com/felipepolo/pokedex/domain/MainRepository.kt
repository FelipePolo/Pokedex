package com.felipepolo.pokedex.domain

import com.felipepolo.pokedex.data.local.LocalDataSource
import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.data.model.PokemonEntity
import com.felipepolo.pokedex.data.remote.NetworkDataSource
import com.felipepolo.pokedex.utils.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
) : MainRepositoryInterface {

    override suspend fun getPokemonsByGeneration(id: String): Resource<List<Pokemon>> {
        return networkDataSource.getPokemonsByGeneration(id)
    }

    override suspend fun getRandomPokemon(): Resource<Pokemon> {
        return networkDataSource.getRandomPokemon()
    }

    override suspend fun saveFavoritePokemon(pokemon: Pokemon) {
        localDataSource.saveFavoritePokemon(pokemon)
    }

    override suspend fun getAllFavoritePokemon(): Resource<List<PokemonEntity>> {
        return localDataSource.getAllFavoritePokemon()
    }

    override suspend fun deleteFavoritePokemon(pokemonEntity: PokemonEntity) {
        localDataSource.deleteFavoritePokemon(pokemonEntity)
    }

}