package es.kiketurry.talkingabout2023.data.repository.pokemon

import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.PokemonInfoResponse
import retrofit2.Response


class DataProviderPokemon private constructor(private val remoteDataSourcePokemon: DataSourcePokemon) : DataSourcePokemon {
    companion object {
        var INSTANCE: DataProviderPokemon? = null

        @Synchronized
        fun getInstance(remoteDataSourcePokemon: DataSourcePokemon): DataProviderPokemon {
            if (INSTANCE == null) {
                INSTANCE = DataProviderPokemon(remoteDataSourcePokemon)
            }
            return INSTANCE!!
        }
    }

    override fun getListPokemon(getListPokemonCallback: DataSourceCallbacksPokemon.GetListPokemonCallback, limit: Int, offset: Int) {
        remoteDataSourcePokemon.getListPokemon(getListPokemonCallback, limit, offset)
    }

    override suspend fun getPokemonByName(name: String): Response<PokemonInfoResponse> {
        return remoteDataSourcePokemon.getPokemonByName(name)
    }
}