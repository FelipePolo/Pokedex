package com.felipepolo.pokedex.data.remote

import com.felipepolo.pokedex.data.model.Generation
import com.felipepolo.pokedex.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WebService {

    @GET("generation/{id}")
    suspend fun getPokemonNamesByGen(@Path("id") id:String):Generation

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): Pokemon

}