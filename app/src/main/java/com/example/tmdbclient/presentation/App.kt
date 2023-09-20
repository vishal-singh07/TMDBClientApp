package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.ApplicationComponent
import com.example.tmdbclient.presentation.di.core.DaggerApplicationComponent
import com.example.tmdbclient.presentation.di.core.NetworkModule
import com.example.tmdbclient.presentation.di.core.RemoteDataSourceModule
import com.example.tmdbclient.presentation.di.movies.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshows.TvShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}