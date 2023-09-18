package com.example.tmdbclient.data.repository.tvshows.datasourceImpl

import com.example.tmdbclient.data.model.tvShows.TvShow
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var showList = ArrayList<TvShow>()
    override suspend fun getShowsFromCache(): List<TvShow> {
        return showList
    }

    override suspend fun saveShowsToCache(shows: List<TvShow>) {
        showList.clear()
        showList = ArrayList(shows)
    }
}