package es.kiketurry.talkingabout2023.data.repository.pokemon

import es.kiketurry.talkingabout2023.data.domain.model.error.ErrorModel
import es.kiketurry.talkingabout2023.data.domain.model.pokemon.GetListPokemonModel
import es.kiketurry.talkingabout2023.data.domain.model.pokemon.PokemonInfoModel

interface DataSourceCallbacksPokemon {
    interface GetListPokemonCallback {
        fun onGetListPokemonCallbackSuccess(getListPokemonResponseModel: GetListPokemonModel)

        fun onGetListPokemonCallbackUnsuccess(errorModel: ErrorModel)

        fun onGetListPokemonCallbackFailure(errorModel: ErrorModel)
    }

    interface GetPokemonByNameCallback {
        fun onPokemonByNameCallbackSuccess(pokemonInfoModel: PokemonInfoModel)

        fun onPokemonByNameCallbackUnsuccess(errorModel: ErrorModel)

        fun onPokemonByNameCallbackFailure(errorModel: ErrorModel)
    }
}