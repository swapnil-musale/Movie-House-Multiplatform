package com.devx.moviehouse.domain.repository

import com.devx.moviehouse.domain.model.PopularMovieResponse

interface HomeRepository {
    suspend fun getPopularMovies(
        movieType: String,
        movieCategory: String,
        pageNo: String
    ): Result<PopularMovieResponse>
}
