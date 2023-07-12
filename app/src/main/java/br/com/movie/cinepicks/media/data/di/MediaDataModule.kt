package br.com.movie.cinepicks.media.data.di

import br.com.movie.cinepicks.media.data.repository.MediaRepositoryImpl
import br.com.movie.cinepicks.media.domain.repository.MediaRepository
import br.com.movie.cinepicks.network.TMDBApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaDataModule {

    @Provides
    @Singleton
    fun providesMediaRepository(
        tmdbApi: TMDBApi
    ): MediaRepository {
        return MediaRepositoryImpl(tmdbApi = tmdbApi)
    }
}