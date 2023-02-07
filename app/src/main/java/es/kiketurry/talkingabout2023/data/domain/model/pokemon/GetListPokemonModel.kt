package es.kiketurry.talkingabout2023.data.domain.model.pokemon

import es.kiketurry.talkingabout2023.data.domain.model.BaseModel

data class GetListPokemonModel(
    val count: Int = -1,
    val next: String = "",
    val previous: String = "",
    val results: List<GetListPokemonResultModel> = arrayListOf()
) : BaseModel()