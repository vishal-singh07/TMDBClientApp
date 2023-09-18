package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.artists.ArtistList
import com.example.tmdbclient.data.model.movies.MovieList
import com.example.tmdbclient.data.model.tvShows.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<ArtistList>
}