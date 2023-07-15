package br.com.movie.cinepicks.media.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.movie.cinepicks.R
import br.com.movie.cinepicks.media.domain.model.Media
import br.com.movie.cinepicks.network.TMDBApi
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun TrendingMedia(
    media: Media?,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    media?.let {
        val image = TMDBApi.BASE_IMAGE_URL + media.posterPath
        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(image)
                    .build(),
                contentDescription = stringResource(
                    id = R.string.trending_media
                ),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
            )
        }
    }
}
