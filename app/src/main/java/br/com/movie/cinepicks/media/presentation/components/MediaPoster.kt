package br.com.movie.cinepicks.media.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.DrawableCompat
import br.com.movie.cinepicks.R
import br.com.movie.cinepicks.media.domain.model.Media
import br.com.movie.cinepicks.network.TMDBApi
import br.com.movie.cinepicks.ui.LocalSpacing
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MediaPoster(
    media: Media,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    val image = TMDBApi.BASE_IMAGE_URL + media.posterPath
    val voteAverage = media.voteAverage

    Column(
        modifier = modifier.width(140.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(
                    id = R.string.poster_image
                ),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .clip(RoundedCornerShape(spacing.spaceSmall))
            )
            voteAverage?.let { vote ->
                Text(text = vote.toString())
            }
        }
        Text(
            text = media.title,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun MediaPosterPreview() {
    MediaPoster(
        media = Media(
            id = "",
            posterPath = "/1E5baAaEse26fej7uHcjOgEE2t2.jpg",
            title = "Fast and Furious",
            voteAverage = 7.0
        )
    )
}