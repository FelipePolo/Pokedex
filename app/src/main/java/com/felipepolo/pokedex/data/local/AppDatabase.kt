package com.felipepolo.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.felipepolo.pokedex.data.model.PokemonEntity

@Database(entities = [PokemonEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}