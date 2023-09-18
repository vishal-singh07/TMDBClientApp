package com.example.tmdbclient.data.repository.artists.datasourceImpl

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.model.artists.Artist
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistListFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistListToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtists()
        }
    }
}