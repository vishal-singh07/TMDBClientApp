package com.example.tmdbclient.presentation.di.core

import android.content.Context
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movies.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshows.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSubComponent::class,TvShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return context.applicationContext
    }
}