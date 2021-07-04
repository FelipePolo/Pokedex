package com.felipepolo.pokedex.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritesPokemon")
data class PokemonEntity(
    @ColumnInfo(name = "name")
    @PrimaryKey(autoGenerate = false)
    var name: String = "",
    @ColumnInfo(name = "img")
    var img: String = ""
)