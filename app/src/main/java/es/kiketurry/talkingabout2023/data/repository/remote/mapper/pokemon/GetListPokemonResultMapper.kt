package es.kiketurry.talkingabout2023.data.repository.remote.mapper.pokemon

import es.kiketurry.talkingabout2023.data.domain.model.pokemon.GetListPokemonResultModel
import es.kiketurry.talkingabout2023.data.repository.remote.mapper.ResponseMapper
import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.GetListPokemonResultResponse

class GetListPokemonResultMapper : ResponseMapper<GetListPokemonResultResponse, GetListPokemonResultModel> {
    override fun fromResponse(response: GetListPokemonResultResponse): GetListPokemonResultModel {
        return GetListPokemonResultModel(response.name ?: "", response.url ?: "")
    }
}