package br.com.movie.cinepicks.media.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movie.cinepicks.network.TMDBApi
import br.com.movie.cinepicks.network.dtos.MediaDto

class TopRatedMoviePagingSource (
    private val movieService: TMDBApi
) : PagingSource<Int, MediaDto>() {

    override fun getRefreshKey(state: PagingState<Int, MediaDto>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MediaDto> {
        val currentPage = params.key ?: 1
        return try {
            val response = movieService.getTopRatedMovies(page = currentPage)
            LoadResult.Page(
                data = response.medias,
                prevKey = if (currentPage == 1) null else currentPage.minus(1),
                nextKey = if (response.medias.isEmpty()) null else currentPage.plus(1)
            )
        } catch (e: Exception) {
            Log.e("PagingSource", "PopularMovie: ${e.stackTrace}")
            LoadResult.Error(e)
        }
    }
}