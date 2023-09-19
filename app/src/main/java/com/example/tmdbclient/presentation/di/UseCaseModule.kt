package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowsRepository
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun providesUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun providesGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun providesGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Singleton
    @Provides
    fun providesUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }
}