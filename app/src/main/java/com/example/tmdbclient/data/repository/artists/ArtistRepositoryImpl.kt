package com.example.tmdbclient.data.repository.artists

import android.util.Log
import com.example.tmdbclient.data.model.artists.Artist
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList: List<Artist> = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistListToDB(newArtistList)
        artistCacheDataSource.saveArtistListToCache(newArtistList)
        return newArtistList
    }
    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        return artistList
    }
    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistListFromDB()
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        if(artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistListToDB(artistList)
        }
        return artistList
    }
    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistListFromCache()
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        if(artistList.isNotEmpty()) {
                return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistListToCache(artistList)
        }
        return artistList
    }
    companion object{
        const val TAG = "ArtistRepositoryImpl"
    }
}