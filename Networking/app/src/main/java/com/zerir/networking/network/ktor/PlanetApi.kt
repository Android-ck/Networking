package com.zerir.networking.network.ktor

import com.zerir.networking.domain.model.PlanetsResponse

interface PlanetApi {

    suspend fun getPlanets(page: Int = 1): PlanetsResponse

}