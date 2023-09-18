package com.example.tmdbclient.data.repository.tvshows.datasource

import com.example.tmdbclient.data.model.tvShows.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getShows(): Response<TvShowList>
}