package br.com.movie.cinepicks.media.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.movie.cinepicks.media.data.paging.PopularMoviePagingSource
import br.com.movie.cinepicks.media.data.paging.TopRatedMoviePagingSource
import br.com.movie.cinepicks.media.domain.model.Media
import br.com.movie.cinepicks.media.domain.repository.MediaRepository
import br.com.movie.cinepicks.network.TMDBApi
import br.com.movie.cinepicks.network.mappers.toMedia
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    private val tmdbApi: TMDBApi
) : MediaRepository {

    override fun getPopularMovies(): Flow<PagingData<Media>> {
        val pagingSourceFactory = { PopularMoviePagingSource(movieService = tmdbApi) }
        val pager = Pager(
            config = PagingConfig(pageSize = TMDBApi.PAGE_SIZE),
            pagingSourceFactory = pagingSourceFactory
        ).flow

        return pager.map { dtoPagingData ->
            dtoPagingData.map { it.toMedia() }
        }
    }

    override fun getTopRatedMovies(): Flow<PagingData<Media>> {
        val pagingSourceFactory = { TopRatedMoviePagingSource(movieService = tmdbApi) }
        val pager = Pager(
            config = PagingConfig(pageSize = TMDBApi.PAGE_SIZE),
            pagingSourceFactory = pagingSourceFactory
        ).flow

        return pager.map { dtoPagingData ->
            dtoPagingData.map { it.toMedia() }
        }
    }

}