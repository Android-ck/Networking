package com.zerir.networking.network.ktor

import io.ktor.client.*

abstract class BaseApi {

    protected lateinit var client: HttpClient

    fun setupClient(client: HttpClient) {
        this.client = client
    }

}