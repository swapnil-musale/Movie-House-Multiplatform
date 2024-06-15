package com.devx.moviehouse.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val movieList: List<MovieData>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)