package com.devx.moviehouse.di

import com.devx.moviehouse.data.repository.HomeRepositoryImpl
import com.devx.moviehouse.domain.repository.HomeRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(movieDatabaseService = get()) }
}