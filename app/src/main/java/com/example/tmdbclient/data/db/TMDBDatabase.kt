package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.artists.Artist
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.data.model.tvShows.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}