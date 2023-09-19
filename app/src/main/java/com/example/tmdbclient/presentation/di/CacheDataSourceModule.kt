package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artists.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdbclient.data.repository.movies.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movies.datasourceImpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshows.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun providesMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}