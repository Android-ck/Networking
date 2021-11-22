package com.zerir.networking.network.ktor

import android.util.Log
import com.zerir.networking.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

class RemoteDataSource {

    companion object {
        const val BASE_URL = "https://api.instantwebtools.net/v1/"
    }

    fun <Api: BaseApi> buildApi(api: Class<Api>): Api {
        val instance = api.newInstance()
        instance.setupClient(buildKtorClient())
        return instance
    }

    private fun logger(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, msg)
        }
    }

    private fun buildKtorClient(): HttpClient = HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

                engine {
                    connectTimeout = 60_000
                    socketTimeout = 60_000
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        logger("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.BODY
            }

            install(ResponseObserver) {
                onResponse { response ->
                    logger("HTTP status:", "${response.status.value}")
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }

}