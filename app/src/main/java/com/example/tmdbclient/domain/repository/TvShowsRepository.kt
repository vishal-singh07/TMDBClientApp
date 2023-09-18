package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.tvShows.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}