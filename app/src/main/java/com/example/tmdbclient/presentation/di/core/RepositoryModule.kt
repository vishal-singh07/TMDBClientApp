package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artists.ArtistRepositoryImpl
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movies.MovieRepositoryImpl
import com.example.tmdbclient.data.repository.movies.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movies.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tvshows.TvShowRepositoryImpl
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}