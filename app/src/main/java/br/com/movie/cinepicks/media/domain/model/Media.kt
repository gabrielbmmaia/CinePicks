package br.com.movie.cinepicks.media.domain.model

data class Media(
    val id: String,
    val title: String,
    val posterPath: String?,
    val voteAverage: Double?
)
