package br.com.movie.cinepicks.media.presentation.movieScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.movie.cinepicks.media.presentation.components.MediaList
import br.com.movie.cinepicks.ui.LocalSpacing

@Composable
fun MovieScreen(
    state: MovieState,
    onEvent: (MovieEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(MovieEvent.OnLoadPopularList)
        onEvent(MovieEvent.OnLoadTopRatedList)
    }

    val spacing = LocalSpacing.current
    val popularList = state.popularList.collectAsLazyPagingItems()
    val topRatedList = state.topRatedList.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium)
            .verticalScroll(rememberScrollState())
    ) {
        MediaList(titleList = "Popular", mediaList = popularList)
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        MediaList(titleList = "Melhores Avaliados", mediaList = topRatedList)
    }
}