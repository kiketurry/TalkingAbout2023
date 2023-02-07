package es.kiketurry.talkingabout2023.data.repository.remote.mapper

interface ResponseMapper<E, M> {
    fun fromResponse(response: E): M
}