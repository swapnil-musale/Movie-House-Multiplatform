package com.devx.moviehouse.domain.useCase

import com.devx.moviehouse.domain.model.PopularMovieResponse
import com.devx.moviehouse.domain.repository.HomeRepository

class GetPopularMoviesUseCase(private val homeRepository: HomeRepository) {
    suspend operator fun invoke(
        movieType: String,
        movieCategory: String,
        pageNo: String,
    ): Result<PopularMovieResponse> {
        return homeRepository.getPopularMovies(
            movieType = movieType,
            movieCategory = movieCategory,
            pageNo = pageNo
        )
    }
}