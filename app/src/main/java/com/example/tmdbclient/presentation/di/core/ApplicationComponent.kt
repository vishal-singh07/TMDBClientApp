package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movies.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshows.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataSourceModule::class,
    DatabaseModule::class,
    LocalDataSourceModule::class,
    NetworkModule::class,
    RemoteDataSourceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface ApplicationComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory

}