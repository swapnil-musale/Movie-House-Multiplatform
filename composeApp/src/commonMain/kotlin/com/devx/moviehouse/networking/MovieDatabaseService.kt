package com.devx.moviehouse.networking

import com.devx.moviehouse.data.model.PopularMovieResponseDto
import com.devx.moviehouse.data.util.NetworkConstant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments

class MovieDatabaseService(private val httpClient: HttpClient) {
    suspend fun getPopularMovies(
        movieType: String,
        movieCategory: String,
        pageNo: String,
    ): PopularMovieResponseDto {
        return httpClient.get {
            url {
                appendPathSegments(movieType, movieCategory)
                parameters.append(name = NetworkConstant.PAGE_NO_PARAM, value = pageNo)
            }
        }.body()
    }
}