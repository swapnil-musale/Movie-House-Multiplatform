package com.devx.moviehouse.networking

import com.devx.kdeviceinfo.DeviceInfoXState
import com.devx.moviehouse.BuildKonfig
import com.devx.moviehouse.data.util.NetworkConstant
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {

    val deviceInfoXState = DeviceInfoXState()
    val isDebugBuild =
        if (deviceInfoXState.isAndroid) deviceInfoXState.androidInfo.isDebug else deviceInfoXState.iosInfo.isDebug

    expectSuccess = true

    install(plugin = DefaultRequest) {
        url(urlString = NetworkConstant.BASE_URL)

        url.parameters.append(
            name = NetworkConstant.API_KEY_HEADER_PARAM,
            value = BuildKonfig.API_KEY
        )
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
        level = if (isDebugBuild) LogLevel.ALL else LogLevel.NONE
    }
}