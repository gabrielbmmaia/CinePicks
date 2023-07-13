package br.com.movie.cinepicks.media.presentation.movieScreen

import androidx.paging.PagingData
import br.com.movie.cinepicks.media.domain.model.Media
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class MovieState(
    val popularList: Flow<PagingData<Media>> = flowOf(PagingData.empty()),
    val topRatedList: Flow<PagingData<Media>> = flowOf(PagingData.empty())
)
