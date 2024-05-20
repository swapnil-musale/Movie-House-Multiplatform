package com.devx.moviehouse.ui.movieList

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieListViewModel : ViewModel() {

    private val _data: MutableStateFlow<String> = MutableStateFlow("")
    val data = _data.asStateFlow()
}