package com.zerir.networking.data

import com.zerir.networking.domain.Repository
import com.zerir.networking.domain.model.PlanetsResponse
import com.zerir.networking.network.AsyncCall
import com.zerir.networking.network.Resource
import com.zerir.networking.network.ktor.PlanetApi

class RepositoryImpl(private val planetApi: PlanetApi) : Repository, AsyncCall {

    override suspend fun getAllPlanets(): Resource<PlanetsResponse> = invokeAsyncCall {
        planetApi.getPlanets()
    }

}