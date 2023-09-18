package com.example.tmdbclient.data.repository.tvshows.datasource

import com.example.tmdbclient.data.model.tvShows.TvShow

interface TvShowCacheDataSource {
    suspend fun getShowsFromCache(): List<TvShow>
    suspend fun saveShowsToCache(shows: List<TvShow>)
}