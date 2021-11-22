package com.zerir.networking.network.ktor

import com.zerir.networking.domain.model.PassengersResponse
import io.ktor.client.request.*

class PassengersApiImpl : BaseApi(), PassengersApi {

    override suspend fun getPassengers(page: Int, size: Int): PassengersResponse {
        return client.get("${RemoteDataSource.BASE_URL}$PASSENGER_PATH/?$PAGE_QUERY=$page&$SIZE_QUERY=$size")
    }

    companion object {
        private const val PASSENGER_PATH = "passenger"
        private const val PAGE_QUERY = "page"
        private const val SIZE_QUERY = "size"
    }

}