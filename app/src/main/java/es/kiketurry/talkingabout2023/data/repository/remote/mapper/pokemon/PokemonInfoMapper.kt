package es.kiketurry.talkingabout2023.data.repository.remote.mapper.pokemon

import es.kiketurry.talkingabout2023.data.domain.model.pokemon.PokemonInfoModel
import es.kiketurry.talkingabout2023.data.domain.model.pokemon.PokemonInfoSpritesModel
import es.kiketurry.talkingabout2023.data.repository.remote.mapper.ResponseMapper
import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.PokemonInfoResponse

class PokemonInfoMapper : ResponseMapper<PokemonInfoResponse, PokemonInfoModel> {
    override fun fromResponse(response: PokemonInfoResponse): PokemonInfoModel {

        val pokemonInfoSpritesModel = if (response.pokemonInfoSpritesResponse != null) {
            PokemonInfoSpritesMapper().fromResponse(response.pokemonInfoSpritesResponse)
        } else {
            PokemonInfoSpritesModel()
        }

        return PokemonInfoModel(
            response.baseExperience ?: -1,
            response.height ?: -1,
            response.id ?: -1,
            response.name ?: "",
            pokemonInfoSpritesModel,
            response.weight ?: -1
        )
    }
}