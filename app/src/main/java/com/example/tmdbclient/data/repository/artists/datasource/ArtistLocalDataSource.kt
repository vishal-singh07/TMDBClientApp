package com.example.tmdbclient.data.repository.artists.datasource

import com.example.tmdbclient.data.model.artists.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistListFromDB(): List<Artist>
    suspend fun saveArtistListToDB(artists: List<Artist>)
    suspend fun clearAll()
}