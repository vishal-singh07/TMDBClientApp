package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artists.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movies.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvshows.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun providesArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun providesTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService,apiKey)
    }
}