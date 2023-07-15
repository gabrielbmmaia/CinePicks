package br.com.movie.cinepicks.media.domain.di

import br.com.movie.cinepicks.media.domain.repository.MediaRepository
import br.com.movie.cinepicks.media.domain.useCases.GetRandomTrendingMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MediaDomainModule {

    @Provides
    fun providesGetRandomTrendingUseCase(
        repository: MediaRepository
    ): GetRandomTrendingMovieUseCase {
        return GetRandomTrendingMovieUseCase(repository)
    }
}