package br.com.movie.cinepicks.media.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.movie.cinepicks.media.data.paging.PopularMoviePagingSource
import br.com.movie.cinepicks.media.data.paging.TheaterMoviePagingSource
import br.com.movie.cinepicks.media.data.paging.TopRatedMoviePagingSource
import br.com.movie.cinepicks.media.data.paging.UpcomingMoviePagingSource
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

    override fun getUpcomingMovies(): Flow<PagingData<Media>> {
        val pagingSourceFactory = { UpcomingMoviePagingSource(movieService = tmdbApi) }
        val pager = Pager(
            config = PagingConfig(pageSize = TMDBApi.PAGE_SIZE),
            pagingSourceFactory = pagingSourceFactory
        ).flow

        return pager.map { dtoPagingData ->
            dtoPagingData.map { it.toMedia() }
        }
    }

    override fun getTheaterMovies(): Flow<PagingData<Media>> {
        val pagingSourceFactory = { TheaterMoviePagingSource(movieService = tmdbApi) }
        val pager = Pager(
            config = PagingConfig(pageSize = TMDBApi.PAGE_SIZE),
            pagingSourceFactory = pagingSourceFactory
        ).flow

        return pager.map { dtoPagingData ->
            dtoPagingData.map { it.toMedia() }
        }
    }

    override suspend fun getTrendingMovies(): Result<List<Media>> {
        return try {
            val result = tmdbApi.getTrendingMedia(
                mediaType = TMDBApi.MOVIE_MEDIA_TYPE,
                timeWindow = TMDBApi.DAY_TIME_WINDOW
            ).medias.map { it.toMedia() }

            Result.success(result)
        } catch (e: Exception) {
            Log.e("MediaRepository", "getTrendingMovies: ${e.stackTrace}")
            Result.failure(e)
        }
    }

}