package br.com.movie.cinepicks.media.presentation.movieScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.movie.cinepicks.media.presentation.components.MediaList

@Composable
fun MovieScreen(
    state: MovieState,
    onEvent: (MovieEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(MovieEvent.OnLoadPopularList)
    }
    val popularList = state.popularList.collectAsLazyPagingItems()
    MediaList(titleList = "Popular", mediaList = popularList)
}