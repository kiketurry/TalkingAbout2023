package es.kiketurry.talkingabout2023.utils

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import es.kiketurry.talkingabout2023.data.domain.model.error.ErrorModel
import es.kiketurry.talkingabout2023.data.repository.remote.mapper.error.ErrorMapper
import es.kiketurry.talkingabout2023.data.repository.remote.responses.error.ErrorResponse
import es.kiketurry.talkingabout2023.extension.TAG
import okhttp3.ResponseBody

class ErrorsUtils {
    companion object {
        fun generateErrorModelFromResponseErrorBody(responseCode: Int, responseBody: ResponseBody?): ErrorModel {
            val gson = Gson()
            var errorResponse: ErrorResponse? = null
            try {
                errorResponse = gson.fromJson(responseBody?.string(), ErrorResponse::class.java)
            } catch (jsonSyntaxException: JsonSyntaxException) {
                Log.d(TAG, "l> generateErrorModelFromResponseErrorBody problem gson: ${jsonSyntaxException.message}")
            } catch (exception: Exception) {
                Log.d(TAG, "l> generateErrorModelFromResponseErrorBody problem exception: ${exception.message}")
            }

            return if (errorResponse != null) {
                ErrorMapper().fromResponse(errorResponse)
            } else if (responseCode == 401) {
                ErrorModel("401", "401", "401")
            } else {
                ErrorModel()
            }
        }

        fun generateErrorModelFromThrowable(throwable: Throwable): ErrorModel {
            Log.e(TAG, "l> ${throwable.message}")
            return ErrorModel(error = "unknow", errorCode = "", message = "unknow")
        }

        fun generateErrorModelFromMessage(message: String): ErrorModel {
            Log.e(TAG, "l> $message")
            return ErrorModel(error = "unknow", errorCode = "", message = message)
        }
    }
}