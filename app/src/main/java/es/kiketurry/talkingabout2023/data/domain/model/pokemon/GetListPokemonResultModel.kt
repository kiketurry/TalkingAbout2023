package es.kiketurry.talkingabout2023.data.domain.model.pokemon

import es.kiketurry.talkingabout2023.data.domain.model.BaseModel

data class GetListPokemonResultModel(
    val name: String = "",
    val url: String = ""
) : BaseModel()