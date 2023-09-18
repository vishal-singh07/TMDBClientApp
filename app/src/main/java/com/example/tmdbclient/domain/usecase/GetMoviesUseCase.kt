package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}