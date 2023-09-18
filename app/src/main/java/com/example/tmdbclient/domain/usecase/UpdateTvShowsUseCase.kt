package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.tvShows.TvShow
import com.example.tmdbclient.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.updateTvShows()
}