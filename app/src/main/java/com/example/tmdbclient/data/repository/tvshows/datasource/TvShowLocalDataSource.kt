package com.example.tmdbclient.data.repository.tvshows.datasource

import com.example.tmdbclient.data.model.tvShows.TvShow

interface TvShowLocalDataSource {
    suspend fun getShowsFromDB(): List<TvShow>
    suspend fun saveShowsToDB(shows: List<TvShow>)
    suspend fun clearAll()
}