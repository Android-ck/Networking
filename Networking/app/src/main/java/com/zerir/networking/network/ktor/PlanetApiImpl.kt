package com.zerir.networking.network.ktor

import com.zerir.networking.domain.model.PlanetsResponse
import io.ktor.client.*
import io.ktor.client.request.*

class PlanetApiImpl : BaseApi(), PlanetApi {

    override suspend fun getPlanets(page: Int): PlanetsResponse {
        return client.get("${RemoteDataSource.BASE_URL}/planets/?page=$page")
    }

}