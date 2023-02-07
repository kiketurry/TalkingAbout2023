package es.kiketurry.talkingabout2023.injection

import androidx.savedstate.SavedStateRegistryOwner
import es.kiketurry.talkingabout2023.ui.base.ViewModelFactory

class Injection {
    companion object {

        fun provideViewModelFactory(savedStateRegistryOwner: SavedStateRegistryOwner): ViewModelFactory {
            return ViewModelFactory.getInstance(
                savedStateRegistryOwner,
                InjectionSingleton.provideDataSourcePokemon(),
                InjectionSingleton.provideEncryptedSharedPreferencesManager(),
                InjectionSingleton.provideDataUserSession()
            )
        }
    }
}