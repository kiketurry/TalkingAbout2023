package es.kiketurry.talkingabout2023.data.repository.remote.mapper.error

import es.kiketurry.talkingabout2023.data.domain.model.error.ErrorModel
import es.kiketurry.talkingabout2023.data.repository.remote.mapper.ResponseMapper
import es.kiketurry.talkingabout2023.data.repository.remote.responses.error.ErrorResponse

class ErrorMapper : ResponseMapper<ErrorResponse, ErrorModel> {
    override fun fromResponse(response: ErrorResponse): ErrorModel {
        return ErrorModel(response.error ?: "", response.errorCode ?: "", response.message ?: "")
    }
}