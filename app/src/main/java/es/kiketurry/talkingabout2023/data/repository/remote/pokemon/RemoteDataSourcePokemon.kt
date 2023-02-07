package es.kiketurry.talkingabout2023.data.repository.remote.pokemon

import es.kiketurry.talkingabout2023.data.repository.pokemon.DataSourceCallbacksPokemon
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataSourcePokemon
import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.PokemonInfoResponse
import retrofit2.Response

class RemoteDataSourcePokemon(private val apiServicePokemon: ApiServicesPokemon) : DataSourcePokemon {
    companion object {
        private var INSTANCE: RemoteDataSourcePokemon? = null

        @Synchronized
        fun getInstance(apiServicesPokemon: ApiServicesPokemon): RemoteDataSourcePokemon {
            if (INSTANCE == null) {
                INSTANCE = RemoteDataSourcePokemon(apiServicesPokemon)
            }
            return INSTANCE!!
        }
    }

    override fun getListPokemon(getListPokemonCallback: DataSourceCallbacksPokemon.GetListPokemonCallback, limit: Int, offset: Int) {
        val getListPokemonCall = apiServicePokemon.getListPokemon(limit, offset)
        getListPokemonCall.enqueue(RetrofitCallbacksPokemon.getListPokemonCallback(getListPokemonCallback))
    }

    override suspend fun getPokemonByName(name: String): Response<PokemonInfoResponse> {
        return apiServicePokemon.getPokemonbyName(name)
    }
}