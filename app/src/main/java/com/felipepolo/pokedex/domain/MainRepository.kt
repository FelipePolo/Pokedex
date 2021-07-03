package com.felipepolo.pokedex.domain

import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.data.remote.NetworkDataSource
import com.felipepolo.pokedex.utils.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(private val networkDataSource: NetworkDataSource): MainRepositoryInterface {

    override suspend fun getPokemonsByGeneration(id: String): Resource<List<Pokemon>> {
        return networkDataSource.getPokemonsByGeneration(id)
    }

}