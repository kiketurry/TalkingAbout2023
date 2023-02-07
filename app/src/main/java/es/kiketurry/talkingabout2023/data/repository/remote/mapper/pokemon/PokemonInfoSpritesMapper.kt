package es.kiketurry.talkingabout2023.data.repository.remote.mapper.pokemon

import es.kiketurry.talkingabout2023.data.domain.model.pokemon.PokemonInfoSpritesModel
import es.kiketurry.talkingabout2023.data.repository.remote.mapper.ResponseMapper
import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.PokemonInfoSpritesResponse

class PokemonInfoSpritesMapper : ResponseMapper<PokemonInfoSpritesResponse, PokemonInfoSpritesModel> {
    override fun fromResponse(response: PokemonInfoSpritesResponse): PokemonInfoSpritesModel {
        return PokemonInfoSpritesModel(
            response.backDefault ?: "",
            response.backFemale ?: "",
            response.backShiny ?: "",
            response.backShinyFemale ?: "",
            response.frontDefault ?: "",
            response.frontFemale ?: "",
            response.frontShiny ?: "",
            response.frontShinyFemale ?: ""
        )
    }
}