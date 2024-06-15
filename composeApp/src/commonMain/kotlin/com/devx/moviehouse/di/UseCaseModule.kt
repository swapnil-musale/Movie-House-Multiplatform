package com.devx.moviehouse.di

import com.devx.moviehouse.domain.useCase.GetPopularMoviesUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    single<GetPopularMoviesUseCase> { GetPopularMoviesUseCase(homeRepository = get()) }
}