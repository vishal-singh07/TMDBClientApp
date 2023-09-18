package com.example.tmdbclient.data.repository.tvshows

import android.util.Log
import com.example.tmdbclient.data.model.tvShows.TvShow
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newShowList: List<TvShow> = getShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveShowsToDB(newShowList)
        tvShowCacheDataSource.saveShowsToCache(newShowList)
        return newShowList
    }
    suspend fun getShowsFromApi(): List<TvShow> {
        lateinit var showList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getShows()
            val body = response.body()
            if (body != null) {
                showList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        return showList
    }
    suspend fun getShowsFromDB(): List<TvShow> {
        lateinit var showList: List<TvShow>
        try {
            showList = tvShowLocalDataSource.getShowsFromDB()
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        if(showList.isNotEmpty()) {
            return showList
        } else {
            showList = getShowsFromApi()
            tvShowLocalDataSource.saveShowsToDB(showList)
        }
        return showList
    }
    suspend fun getShowsFromCache(): List<TvShow> {
        lateinit var showList: List<TvShow>
        try {
            showList = tvShowCacheDataSource.getShowsFromCache()
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        if(showList.isNotEmpty()) {
            return showList
        } else {
            showList = getShowsFromDB()
            tvShowCacheDataSource.saveShowsToCache(showList)
        }
        return showList
    }
    companion object{
        const val TAG = "TvShowRepositoryImpl"
    }
}