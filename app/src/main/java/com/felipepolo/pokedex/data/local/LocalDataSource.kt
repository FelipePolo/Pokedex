package com.felipepolo.pokedex.data.local

import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.data.model.PokemonEntity
import com.felipepolo.pokedex.data.model.asPokemonEntity
import com.felipepolo.pokedex.utils.Resource
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val pokemonDao: PokemonDao) {

    suspend fun getAllFavoritePokemon():Resource<List<PokemonEntity>>{
        return Resource.Success(
            pokemonDao.getAllFavoritePokemon()
        )
    }

    suspend fun saveFavoritePokemon(pokemon: Pokemon){
        pokemonDao.saveFavoritePokemon(pokemon.asPokemonEntity())
    }

    suspend fun deleteFavoritePokemon(pokemonEntity: PokemonEntity){
        pokemonDao.deleteFavoritePokemon(pokemonEntity)
    }
}