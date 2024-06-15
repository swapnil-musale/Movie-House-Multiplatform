package com.devx.moviehouse.data.repository

import com.devx.moviehouse.domain.model.PopularMovieResponse
import com.devx.moviehouse.domain.repository.HomeRepository
import com.devx.moviehouse.networking.MovieDatabaseService
import io.ktor.client.plugins.ResponseException

class HomeRepositoryImpl(private val movieDatabaseService: MovieDatabaseService) : HomeRepository {
    override suspend fun getPopularMovies(
        movieType: String,
        movieCategory: String,
        pageNo: String,
    ): Result<PopularMovieResponse> {
        return try {
            val response = movieDatabaseService.getPopularMovies(
                movieType = movieType,
                movieCategory = movieCategory,
                pageNo = pageNo
            ).mapToDomain()
            Result.success(value = response)
        } catch (exception: ResponseException) {
            Result.failure(exception = Throwable(exception.message))
        } catch (exception: Exception) {
            Result.failure(exception = Throwable(exception.message))
        }
    }
}