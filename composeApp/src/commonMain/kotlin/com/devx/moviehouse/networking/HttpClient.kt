package com.devx.moviehouse.networking

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {
    defaultRequest {
        url(urlString = "https://api.themoviedb.org/3/")
        contentType(ContentType.Application.Json)
        parameters {
            append(name = "api_key", value = "-")
        }
    }

    install(plugin = ContentNegotiation) {
        json(
            json = Json {
                ignoreUnknownKeys = true
            }
        )
    }

    install(plugin = Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }
}