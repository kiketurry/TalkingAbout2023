package es.kiketurry.talkingabout2023.data.repository.remote.pokemon

import com.google.gson.GsonBuilder
import es.kiketurry.talkingabout2023.BuildConfig
import es.kiketurry.talkingabout2023.data.constants.GeneralConstants.Companion.RETROFIT_TIMEOUT_IN_SECOND
import es.kiketurry.talkingabout2023.data.session.DataUserSession
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier


class RetrofitClientPokemon(
    private val dataUserSession: DataUserSession
) {
    companion object {
        var INSTANCE: RetrofitClientPokemon? = null

        @Synchronized
        fun getInstance(
            dataUserSession: DataUserSession
        ): RetrofitClientPokemon {
            if (INSTANCE == null) {
                INSTANCE = RetrofitClientPokemon(dataUserSession)
            }
            return INSTANCE!!
        }
    }

    private val retrofit: Retrofit
    private val apiServicesPokemon: ApiServicesPokemon

    init {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        val certificatePinner = CertificatePinner.Builder()
            .add("pokeapi.co", "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=")
            .build()
        httpClient.certificatePinner(certificatePinner)

        httpClient
            .connectTimeout(RETROFIT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            .readTimeout(RETROFIT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            .writeTimeout(RETROFIT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS)

        httpClient.hostnameVerifier(HostnameVerifier { hostname, session -> true })

        if (BuildConfig.DEBUG) {
            // Creamos un interceptor y le indicamos el log level a usar
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(logging)
        }

        val gson = GsonBuilder().setLenient().create()

        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_POKEMON)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        apiServicesPokemon = retrofit.create(ApiServicesPokemon::class.java)
    }

    fun getApiServices(): ApiServicesPokemon {
        return apiServicesPokemon
    }
}