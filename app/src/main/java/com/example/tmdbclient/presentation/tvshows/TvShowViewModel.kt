package com.example.tmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getShows() = liveData {
        val showList = getTvShowsUseCase.execute()
        emit(showList)
    }

    fun updateShows() = liveData {
        val showList = updateTvShowsUseCase.execute()
        emit(showList)
    }

}