package com.devx.moviehouse.data.model

import com.devx.moviehouse.domain.model.PopularMovieResponse
import com.devx.moviehouse.domain.util.Mapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponseDto(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val movieList: List<MovieDataDto>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
) : Mapper<PopularMovieResponse> {
    override fun mapToDomain(): PopularMovieResponse {
        return PopularMovieResponse(
            page = page,
            movieList = movieList.map { it.mapToDomain() },
            totalPages = totalPages,
            totalResults = totalResults
        )
    }
}