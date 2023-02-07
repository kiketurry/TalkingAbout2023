package es.kiketurry.talkingabout2023.data.repository.pokemon

import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.PokemonInfoResponse
import retrofit2.Response

interface DataSourcePokemon {
    fun getListPokemon(getListPokemonCallback: DataSourceCallbacksPokemon.GetListPokemonCallback, limit: Int, offset: Int)
    suspend fun getPokemonByName(name: String): Response<PokemonInfoResponse>
}