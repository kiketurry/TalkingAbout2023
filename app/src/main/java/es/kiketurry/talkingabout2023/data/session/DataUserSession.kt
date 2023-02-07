package es.kiketurry.talkingabout2023.data.session

import java.io.Serializable

class DataUserSession private constructor() : Serializable {

    private var nameUser: String? = null
    var tokenIb: String = ""

    companion object {
        private var INSTANCE: DataUserSession? = null

        @Synchronized
        fun getInstance(): DataUserSession {
            if (INSTANCE == null) {
                INSTANCE = DataUserSession()
            }
            return INSTANCE!!
        }
    }
}