package es.kiketurry.talkingabout2023.ui.base

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import es.kiketurry.talkingabout2023.data.constants.SharedPreferencesKeys.Companion.SHARED_PREFERENCES_KEY_FIREBASE_UUID
import es.kiketurry.talkingabout2023.extension.TAG
import es.kiketurry.talkingabout2023.injection.InjectionSingleton


class TalkingAboutApplication : Application() {
    companion object {
        private lateinit var appContext: Context

        fun getAppContext(): Context {
            return appContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext

        configFirebase()
    }

    private fun configFirebase() {
        FirebaseMessaging.getInstance().subscribeToTopic("all")
        FirebaseInstallations.getInstance().id.addOnCompleteListener { idResult ->
            var uuid = ""
            if (!idResult.result.isNullOrEmpty()) {
                uuid = idResult.result.toString()
            }
            InjectionSingleton.provideEncryptedSharedPreferencesManager().set(SHARED_PREFERENCES_KEY_FIREBASE_UUID, uuid)
            Log.d(TAG, "l> uuid: $uuid")
        }
    }

}