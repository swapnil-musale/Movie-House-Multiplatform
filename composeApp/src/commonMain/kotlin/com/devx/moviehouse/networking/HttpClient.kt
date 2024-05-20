package com.devx.moviehouse.networking

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {
    defaultRequest {
        url("https://api.themoviedb.org/3/")
    }

    install(ContentNegotiation) {
        json(
            json = Json {
                ignoreUnknownKeys = true
            }
        )
    }

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }
}