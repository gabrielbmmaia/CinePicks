package br.com.movie.cinepicks.network.dtos

import com.google.gson.annotations.SerializedName

data class MediaDto(
    val id: String,
    val title: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?
)
