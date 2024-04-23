package com.devx.moviehouse

import android.app.Application

class MovieHouseApp : Application() {
    companion object {
        lateinit var INSTANCE: MovieHouseApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}