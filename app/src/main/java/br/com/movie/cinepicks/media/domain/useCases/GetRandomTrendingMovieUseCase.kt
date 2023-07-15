package br.com.movie.cinepicks.media.domain.useCases

import br.com.movie.cinepicks.media.domain.model.Media
import br.com.movie.cinepicks.media.domain.repository.MediaRepository
import javax.inject.Inject

class GetRandomTrendingMovieUseCase @Inject constructor(
    private val mediaRepository: MediaRepository
) {
    suspend operator fun invoke(): Result<Media> {
        return mediaRepository
            .getTrendingMovies()
            .map { it.take(5).random() }
    }
}