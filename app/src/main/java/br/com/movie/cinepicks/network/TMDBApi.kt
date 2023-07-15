package br.com.movie.cinepicks.network

import br.com.movie.cinepicks.BuildConfig
import br.com.movie.cinepicks.network.dtos.MediaResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("api_key") key: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("region") region: String = DEFAULT_REGION
    ): MediaResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int,
        @Query("api_key") key: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("region") region: String = DEFAULT_REGION
    ): MediaResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
        @Query("api_key") key: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("region") region: String = DEFAULT_REGION
    ): MediaResponse

    @GET("movie/now_playing")
    suspend fun getTheaterMovies(
        @Query("page") page: Int,
        @Query("api_key") key: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("region") region: String = DEFAULT_REGION
    ): MediaResponse

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMedia(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("language") language: String = DEFAULT_LANGUAGE,
        @Query("api_key") key: String = API_KEY
    ): MediaResponse

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        private val API_KEY = BuildConfig.API_KEY
        private const val DEFAULT_LANGUAGE = "en-US"
        private const val DEFAULT_REGION = "BR"
        const val PAGE_SIZE = 20
        const val MOVIE_MEDIA_TYPE = "movie"
        const val DAY_TIME_WINDOW = "day"
    }
}