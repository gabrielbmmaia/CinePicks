package br.com.movie.cinepicks.network.mappers

import br.com.movie.cinepicks.media.domain.model.Media
import br.com.movie.cinepicks.network.dtos.MediaDto

fun MediaDto.toMedia(): Media {
    return Media(
        id = id,
        title = title,
        posterPath = posterPath,
        voteAverage = voteAverage
    )
}