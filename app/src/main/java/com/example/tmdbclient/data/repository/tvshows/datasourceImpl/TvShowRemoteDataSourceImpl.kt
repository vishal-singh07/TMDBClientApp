package com.example.tmdbclient.data.repository.tvshows.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.tvShows.TvShowList
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowRemoteDataSource {
    override suspend fun getShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}