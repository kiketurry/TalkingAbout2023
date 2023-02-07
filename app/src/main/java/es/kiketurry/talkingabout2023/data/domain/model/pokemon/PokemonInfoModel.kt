package es.kiketurry.talkingabout2023.data.domain.model.pokemon


import es.kiketurry.talkingabout2023.data.domain.model.BaseModel

data class PokemonInfoModel(
    val baseExperience: Int = -1,
    val height: Int = -1,
    val id: Int = -1,
    val name: String = "",
    val pokemonInfoSpritesModel: PokemonInfoSpritesModel = PokemonInfoSpritesModel(),
    val weight: Int = -1
) : BaseModel()