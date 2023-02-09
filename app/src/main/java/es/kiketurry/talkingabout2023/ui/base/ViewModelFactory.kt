package es.kiketurry.talkingabout2023.ui.base

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataProviderPokemon
import es.kiketurry.talkingabout2023.data.repository.sharedpreferences.EncryptedSharedPreferencesManager
import es.kiketurry.talkingabout2023.data.session.DataUserSession
import es.kiketurry.talkingabout2023.ui.channel.ChannelViewModel
import es.kiketurry.talkingabout2023.ui.livedata.LiveDataViewModel
import es.kiketurry.talkingabout2023.ui.main.MainViewModel

class ViewModelFactory(
    private val savedStateRegistryOwner: SavedStateRegistryOwner,
    private val dataProviderPokemon: DataProviderPokemon,
    private val encryptedSharedPreferencesManager: EncryptedSharedPreferencesManager,
    private val dataUserSession: DataUserSession
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    companion object {
        @Synchronized
        fun getInstance(
            savedStateRegistryOwner: SavedStateRegistryOwner,
            dataProviderPokemon: DataProviderPokemon,
            encryptedSharedPreferencesManager: EncryptedSharedPreferencesManager,
            dataUserSession: DataUserSession
        ): ViewModelFactory {
            return ViewModelFactory(savedStateRegistryOwner, dataProviderPokemon, encryptedSharedPreferencesManager, dataUserSession)
        }
    }

    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, savedStateHandle: SavedStateHandle): T {
        val viewModel: ViewModel = when (modelClass.name) {
            MainViewModel::class.qualifiedName -> {
                MainViewModel(
                    savedStateHandle = savedStateHandle,
                    dataProviderPokemon = dataProviderPokemon,
                    dataUserSession = dataUserSession,
                    encryptedSharedPreferencesManager = encryptedSharedPreferencesManager
                )
            }
            ChannelViewModel::class.qualifiedName -> {
                ChannelViewModel(
                    savedStateHandle = savedStateHandle,
                    dataProviderPokemon = dataProviderPokemon,
                    dataUserSession = dataUserSession,
                    encryptedSharedPreferencesManager = encryptedSharedPreferencesManager
                )
            }
            LiveDataViewModel::class.qualifiedName -> {
                LiveDataViewModel(
                    savedStateHandle = savedStateHandle,
                    dataProviderPokemon = dataProviderPokemon,
                    dataUserSession = dataUserSession,
                    encryptedSharedPreferencesManager = encryptedSharedPreferencesManager
                )
            }
            else -> {
                SimplyViewModel(
                    savedStateHandle = savedStateHandle,
                    dataProviderPokemon = dataProviderPokemon,
                    dataUserSession = dataUserSession,
                    encryptedSharedPreferencesManager = encryptedSharedPreferencesManager
                )
            }
        }

        return viewModel as T
    }
}