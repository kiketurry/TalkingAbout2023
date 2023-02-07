package es.kiketurry.talkingabout2023.injection

import es.kiketurry.talkingabout2023.data.repository.pokemon.DataProviderPokemon
import es.kiketurry.talkingabout2023.data.repository.remote.pokemon.ApiServicesPokemon
import es.kiketurry.talkingabout2023.data.repository.remote.pokemon.RemoteDataSourcePokemon
import es.kiketurry.talkingabout2023.data.repository.remote.pokemon.RetrofitClientPokemon
import es.kiketurry.talkingabout2023.data.repository.sharedpreferences.EncryptedSharedPreferencesManager
import es.kiketurry.talkingabout2023.data.session.DataUserSession
import es.kiketurry.talkingabout2023.ui.base.BaseActivityControlShowLoading

class InjectionSingleton {
    companion object {
        fun provideEncryptedSharedPreferencesManager(): EncryptedSharedPreferencesManager {
            return EncryptedSharedPreferencesManager.getInstance()
        }

        private fun provideApiServicesPokemon(): ApiServicesPokemon {
            return RetrofitClientPokemon.getInstance(
                provideDataUserSession()
            ).getApiServices()
        }

        fun provideDataSourcePokemon(): DataProviderPokemon {
            return DataProviderPokemon.getInstance(RemoteDataSourcePokemon.getInstance(provideApiServicesPokemon()))
        }

        fun provideDataUserSession(): DataUserSession {
            return DataUserSession.getInstance()
        }

        fun provideBaseActivityControlShowLoading(): BaseActivityControlShowLoading {
            return BaseActivityControlShowLoading.getInstance()
        }
    }
}