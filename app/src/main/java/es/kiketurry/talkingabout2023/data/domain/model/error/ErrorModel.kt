package es.kiketurry.talkingabout2023.data.domain.model.error

import es.kiketurry.talkingabout2023.data.domain.model.BaseModel

class ErrorModel(
    var error: String = "unknow",
    var errorCode: String = "",
    var message: String = "unknow"
) : BaseModel() {}