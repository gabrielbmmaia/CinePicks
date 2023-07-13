package br.com.movie.cinepicks.media.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import br.com.movie.cinepicks.media.domain.model.Media
import br.com.movie.cinepicks.ui.LocalSpacing
import kotlinx.coroutines.flow.flowOf

@Composable
fun MediaList(
    titleList: String,
    mediaList: LazyPagingItems<Media>,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
    ) {
        Text(text = titleList)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
            ) {
            items(
                count = mediaList.itemCount,
                key = mediaList.itemKey(key = { it.id })
            ) { index ->
                val media = mediaList[index]
                media?.let {
                    MediaPoster(media = it)
                }
            }
        }
    }
}