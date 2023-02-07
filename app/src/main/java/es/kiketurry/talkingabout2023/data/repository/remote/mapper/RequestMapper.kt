package es.kiketurry.talkingabout2023.data.repository.remote.mapper

interface RequestMapper<M, E> {
    fun toRequest(model: M): E
}