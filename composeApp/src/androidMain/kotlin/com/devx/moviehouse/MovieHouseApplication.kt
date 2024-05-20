package com.devx.moviehouse

import android.app.Application
import com.devx.moviehouse.di.KoinInitializer

class MovieHouseApplication : Application() {
    companion object {
        lateinit var INSTANCE: MovieHouseApplication
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
        KoinInitializer(applicationContext).init()
    }
}