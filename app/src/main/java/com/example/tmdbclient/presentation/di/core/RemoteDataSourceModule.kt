package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artists.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movies.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvshows.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule() {

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun providesArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun providesTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }
}