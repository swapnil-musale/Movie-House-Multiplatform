package com.devx.moviehouse

import android.app.Application

class MovieHouseApplication : Application() {
    companion object {
        lateinit var INSTANCE: MovieHouseApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}