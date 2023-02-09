package es.kiketurry.talkingabout2023.ui.channel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataProviderPokemon
import es.kiketurry.talkingabout2023.data.repository.sharedpreferences.EncryptedSharedPreferencesManager
import es.kiketurry.talkingabout2023.data.session.DataUserSession
import es.kiketurry.talkingabout2023.ui.base.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ChannelViewModel(
    savedStateHandle: SavedStateHandle,
    dataProviderPokemon: DataProviderPokemon,
    dataUserSession: DataUserSession,
    encryptedSharedPreferencesManager: EncryptedSharedPreferencesManager
) :
    BaseViewModel(savedStateHandle, dataProviderPokemon, dataUserSession, encryptedSharedPreferencesManager) {

    private val _channel = Channel<Int>()
    val channel = _channel.receiveAsFlow()

    fun loadInfo() {
        viewModelScope.launch {
            delay(500)
            _channel.send(1)
        }
    }

}