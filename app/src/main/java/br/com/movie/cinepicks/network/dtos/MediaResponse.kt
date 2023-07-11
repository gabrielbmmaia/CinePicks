package br.com.movie.cinepicks.network.dtos

import com.google.gson.annotations.SerializedName

data class MediaResponse(
    val page: Int,
    @SerializedName("results")
    val medias: List<MediaDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
