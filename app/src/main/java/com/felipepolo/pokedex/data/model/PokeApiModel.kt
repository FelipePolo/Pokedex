package com.felipepolo.pokedex.data.model

import com.google.gson.annotations.SerializedName

class Generation{
    var pokemon_species: ArrayList<PokemonNames> = arrayListOf()
}

class PokemonNames {
    var name:String = ""
}

class Pokemon{
    var id:Int = 0
    var base_experience:Int = 0
    var height:Int = 0
    var weight:Int = 0
    var moves: ArrayList<Moveindex> = arrayListOf()
    var name:String = ""
    var sprites: Sprites = Sprites()
    var types: ArrayList<Type> = arrayListOf()
    var stats: ArrayList<StatsItems> = arrayListOf()
}

class Moveindex{
    var move: Move = Move()
}

class Move{
    var name: String = ""
}

class Sprites{
    var front_default:String = ""

    var other: Other = Other()
    var versions: Versions = Versions()
}

class Other{
    @SerializedName("official-artwork")
    var official_artwork: OfficialArtwork = OfficialArtwork()
}
class OfficialArtwork{
    var front_default: String = ""
}

class Versions{
    @SerializedName("generation-i")
    var generation1: Generationgame = Generationgame()
    @SerializedName("generation-ii")
    var generation2: Generationgame = Generationgame()
    @SerializedName("generation-iii")
    var generation3: Generationgame = Generationgame()
    @SerializedName("generation-iv")
    var generation4: Generationgame = Generationgame()
    @SerializedName("generation-v")
    var generation5: Generationgame = Generationgame()
}

class Generationgame{
    @SerializedName("red-blue")
    var redblue: Spritegames = Spritegames()
    var yellow:Spritegames = Spritegames()
    var crystal:Spritegames = Spritegames()
    var gold:Spritegames = Spritegames()
    var silver:Spritegames = Spritegames()
    var emerald:Spritegames = Spritegames()
}

class Spritegames{
    var back_default:String = ""
    var front_gray:String = ""
}

class Type{
    var type: Type = Type()
    var name:String  = ""
}

class StatsItems{
    var base_stat: Int= 0
    var stat: Stat = Stat()
}

class Stat{
    var name:String = ""
}