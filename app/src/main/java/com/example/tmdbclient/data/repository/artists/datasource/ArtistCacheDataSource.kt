package com.example.tmdbclient.data.repository.artists.datasource

import com.example.tmdbclient.data.model.artists.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistListFromCache(): List<Artist>
    suspend fun saveArtistListToCache(artists: List<Artist>)
}