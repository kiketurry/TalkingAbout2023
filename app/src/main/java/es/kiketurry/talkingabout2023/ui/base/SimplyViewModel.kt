package es.kiketurry.talkingabout2023.ui.base

import androidx.lifecycle.SavedStateHandle
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataProviderPokemon
import es.kiketurry.talkingabout2023.data.repository.sharedpreferences.EncryptedSharedPreferencesManager
import es.kiketurry.talkingabout2023.data.session.DataUserSession

class SimplyViewModel(
    savedStateHandle: SavedStateHandle,
    dataProviderPokemon: DataProviderPokemon,
    dataUserSession: DataUserSession,
    encryptedSharedPreferencesManager: EncryptedSharedPreferencesManager
) :
    BaseViewModel(savedStateHandle, dataProviderPokemon, dataUserSession, encryptedSharedPreferencesManager) {
}