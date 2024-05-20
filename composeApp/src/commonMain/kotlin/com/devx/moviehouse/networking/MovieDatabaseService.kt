package com.devx.moviehouse.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType

class MovieDatabaseService(private val httpClient: HttpClient) {
    suspend fun getTrendingMovies(type: String, category: String): HttpResponse {
        return httpClient.get {
            url {
                contentType(ContentType.Application.Json)
                appendPathSegments(type, category)
                parameters.append("page", "1")
                parameters.append("api_key", "-")
            }
        }
    }
}