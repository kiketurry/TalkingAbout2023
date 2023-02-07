package es.kiketurry.talkingabout2023.data.repository.remote.pokemon

import android.util.Log
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataSourceCallbacksPokemon
import es.kiketurry.talkingabout2023.data.repository.remote.mapper.pokemon.PokemonInfoMapper
import es.kiketurry.talkingabout2023.data.repository.remote.responses.pokemon.PokemonInfoResponse
import es.kiketurry.talkingabout2023.extension.TAG
import es.kiketurry.talkingabout2023.utils.ErrorsUtils
import retrofit2.Response

class RetrofitSuspendResponsePokemon {
    companion object {
        fun analizeGetPokemonbyNameCallback(
            getPokemonByNameCallback: DataSourceCallbacksPokemon.GetPokemonByNameCallback,
            response: Response<PokemonInfoResponse>
        ) {
            if (response.isSuccessful) {
                if (response.body() != null) {
                    Log.i(TAG, "l> Éxito en la respuesta de analizeGetPokemonbyNameCallback.")
                    getPokemonByNameCallback.onPokemonByNameCallbackSuccess(
                        PokemonInfoMapper().fromResponse(response.body()!!)
                    )
                } else {
                    Log.e(TAG, "l> Problemas en la respuesta de analizeGetPokemonbyNameCallback.")
                    getPokemonByNameCallback.onPokemonByNameCallbackUnsuccess(
                        ErrorsUtils.generateErrorModelFromResponseErrorBody(response.code(), response.errorBody())
                    )
                }
            } else {
                Log.e(TAG, "l> Problemas en la respuesta de analizeGetPokemonbyNameCallback failure.")
                getPokemonByNameCallback.onPokemonByNameCallbackFailure(
                    ErrorsUtils.generateErrorModelFromResponseErrorBody(response.code(), response.errorBody())
                )
            }
        }
    }

}