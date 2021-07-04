package com.felipepolo.pokedex.data.local

import androidx.room.*
import com.felipepolo.pokedex.data.model.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM favoritesPokemon")
    suspend fun getAllFavoritePokemon(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoritePokemon(pokemonEntity: PokemonEntity)

    @Delete
    suspend fun deleteFavoritePokemon(pokemonEntity: PokemonEntity)
}