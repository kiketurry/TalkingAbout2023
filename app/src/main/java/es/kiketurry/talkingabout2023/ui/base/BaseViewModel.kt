package es.kiketurry.talkingabout2023.ui.base

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import es.kiketurry.talkingabout2023.data.domain.model.error.ErrorModel
import es.kiketurry.talkingabout2023.data.repository.pokemon.DataProviderPokemon
import es.kiketurry.talkingabout2023.data.repository.sharedpreferences.EncryptedSharedPreferencesManager
import es.kiketurry.talkingabout2023.data.session.DataUserSession
import es.kiketurry.talkingabout2023.extension.TAG
import es.kiketurry.talkingabout2023.ui.base.BaseViewModel.ViewModelSavedStateHandleKey.SAVED_STATE_HANDLE_KEY_TOKEN_IB

abstract class BaseViewModel(
    val savedStateHandle: SavedStateHandle? = null,
    val dataProviderPokemon: DataProviderPokemon,
    val dataUserSession: DataUserSession,
    val encryptedSharedPreferencesManager: EncryptedSharedPreferencesManager
) :
    AndroidViewModel(TalkingAboutApplication.getAppContext() as Application) {

    enum class ViewModelSavedStateHandleKey(val key: String) {
        SAVED_STATE_HANDLE_KEY_TOKEN_IB("saveStateHandleKeyTokenIb"),
    }

    var loadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var errorMutableLiveData: MutableLiveData<ErrorModel> = MutableLiveData()
    var checkErrorNeedFinishSession401MutableLiveData: MutableLiveData<ErrorModel> = MutableLiveData()


    open fun getKeysNeedSaveStateHandler(): ArrayList<ViewModelSavedStateHandleKey> {
        return arrayListOf(
            SAVED_STATE_HANDLE_KEY_TOKEN_IB,
        )
    }

    open fun saveDataViewModelCouldBeDestroyed(keyList: ArrayList<ViewModelSavedStateHandleKey>) {
        if (keyList.isNotEmpty()) {
            keyList.forEach { key ->
                when (key) {
                    SAVED_STATE_HANDLE_KEY_TOKEN_IB -> {
                        savedStateHandle?.set(SAVED_STATE_HANDLE_KEY_TOKEN_IB.key, dataUserSession.tokenIb)
                    }
                    else -> Unit
                }
            }
        }
    }

    open fun restoreDataViewModelIfExists(keyList: ArrayList<ViewModelSavedStateHandleKey>) {
        if (keyList.isNotEmpty() && savedStateHandle != null) {
            keyList.forEach { key ->
                when (key) {
                    SAVED_STATE_HANDLE_KEY_TOKEN_IB -> {
                        if (savedStateHandle.contains(SAVED_STATE_HANDLE_KEY_TOKEN_IB.key)) {
                            dataUserSession.tokenIb = (savedStateHandle.get<String>(SAVED_STATE_HANDLE_KEY_TOKEN_IB.key)!!)
                        }
                    }
                    else -> Unit
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "l> onCleared")
    }
}