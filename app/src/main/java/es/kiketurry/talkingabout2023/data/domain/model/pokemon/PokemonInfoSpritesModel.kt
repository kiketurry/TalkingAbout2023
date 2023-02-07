package es.kiketurry.talkingabout2023.data.domain.model.pokemon


import es.kiketurry.talkingabout2023.data.domain.model.BaseModel

data class PokemonInfoSpritesModel(
    val backDefault: String = "",
    val backFemale: String = "",
    val backShiny: String = "",
    val backShinyFemale: String = "",
    val frontDefault: String = "",
    val frontFemale: String = "",
    val frontShiny: String = "",
    val frontShinyFemale: String = ""
) : BaseModel()