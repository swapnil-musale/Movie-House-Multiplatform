package com.devx.moviehouse.di

import com.devx.moviehouse.networking.MovieDatabaseService
import com.devx.moviehouse.networking.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

internal val networkModule = module {

    single<HttpClient> {
        httpClient
    }

    single<MovieDatabaseService> {
        MovieDatabaseService(httpClient = get())
    }
}