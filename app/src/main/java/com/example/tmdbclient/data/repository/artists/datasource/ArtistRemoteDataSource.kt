package com.example.tmdbclient.data.repository.artists.datasource

import com.example.tmdbclient.data.model.artists.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}