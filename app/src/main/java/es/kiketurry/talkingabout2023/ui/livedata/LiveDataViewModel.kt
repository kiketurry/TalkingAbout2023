package es.kiketurry.talkingabout2023.ui.livedata

import androidx.lifecycle.SavedStateHandle
import es.kiketurry.talkingabout2023.data.domain.model.error.ErrorModel
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataProviderPokemon
import es.kiketurry.talkingabout2023.data.repository.sharedpreferences.EncryptedSharedPreferencesManager
import es.kiketurry.talkingabout2023.data.session.DataUserSession
import es.kiketurry.talkingabout2023.ui.base.BaseViewModel

class LiveDataViewModel(
    savedStateHandle: SavedStateHandle,
    dataProviderPokemon: DataProviderPokemon,
    dataUserSession: DataUserSession,
    encryptedSharedPreferencesManager: EncryptedSharedPreferencesManager
) :
    BaseViewModel(savedStateHandle, dataProviderPokemon, dataUserSession, encryptedSharedPreferencesManager) {

    fun loadInfo() {
        errorMutableLiveData.postValue(ErrorModel())
    }

}