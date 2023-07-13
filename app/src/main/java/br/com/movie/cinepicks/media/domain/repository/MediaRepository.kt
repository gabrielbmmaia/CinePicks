package br.com.movie.cinepicks.media.domain.repository

import androidx.paging.PagingData
import br.com.movie.cinepicks.media.domain.model.Media
import kotlinx.coroutines.flow.Flow

interface MediaRepository {

    fun getPopularMovies(): Flow<PagingData<Media>>
    fun getTopRatedMovies(): Flow<PagingData<Media>>
    fun getUpcomingMovies(): Flow<PagingData<Media>>
    fun getTheaterMovies(): Flow<PagingData<Media>>
}