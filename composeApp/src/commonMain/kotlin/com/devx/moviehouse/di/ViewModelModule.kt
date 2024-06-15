package com.devx.moviehouse.di

import com.devx.moviehouse.ui.movieList.MovieListViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModelOf(::MovieListViewModel)
}