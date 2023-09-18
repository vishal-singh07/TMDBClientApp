package com.example.tmdbclient.data.repository.artists.datasourceImpl

import com.example.tmdbclient.data.model.artists.Artist
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistListFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistListToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}