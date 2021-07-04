package com.felipepolo.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class Generation(
    var pokemon_species: ArrayList<PokemonNames> = arrayListOf()
)

data class PokemonNames (
    var name:String = ""
)

data class Pokemon(
    var id:Int = 0,
    var base_experience:Int = 0,
    var height:Int = 0,
    var weight:Int = 0,
    var moves: ArrayList<Moveindex> = arrayListOf(),
    var name:String = "",
    var sprites: Sprites = Sprites(),
    var types: ArrayList<Type> = arrayListOf(),
    var stats: ArrayList<StatsItems> = arrayListOf()
)

data class Moveindex(
    var move: Move = Move()
)

data class Move(
    var name: String = ""
)

data class Sprites(
    var front_default:String = "",

    var other: Other = Other(),
    var versions: Versions = Versions()
)

data class Other(
    @SerializedName("official-artwork")
    var official_artwork: OfficialArtwork = OfficialArtwork()
)

data class OfficialArtwork(
    var front_default: String = ""
)

data class Versions(
    @SerializedName("generation-i")
    var generation1: Generationgame = Generationgame(),
    @SerializedName("generation-ii")
    var generation2: Generationgame = Generationgame(),
    @SerializedName("generation-iii")
    var generation3: Generationgame = Generationgame(),
    @SerializedName("generation-iv")
    var generation4: Generationgame = Generationgame(),
    @SerializedName("generation-v")
    var generation5: Generationgame = Generationgame()
)

data class Generationgame(
    @SerializedName("red-blue")
    var redblue: Spritegames = Spritegames(),
    var yellow:Spritegames = Spritegames(),
    var crystal:Spritegames = Spritegames(),
    var gold:Spritegames = Spritegames(),
    var silver:Spritegames = Spritegames(),
    var emerald:Spritegames = Spritegames()
)

data class Spritegames(
    var back_default:String = "",
    var front_gray:String = ""
)

data class Type(
    var type: TypeName = TypeName()
)

data class TypeName(
    var name:String  = ""
)

data class StatsItems(
    var base_stat: Int= 0,
    var stat: Stat = Stat()
)

data class Stat(
    var name:String = ""
)

fun Pokemon.asPokemonEntity(): PokemonEntity {
    return PokemonEntity(this.name, this.sprites.other.official_artwork.front_default)
}