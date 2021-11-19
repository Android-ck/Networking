package com.zerir.networking.data

import com.zerir.networking.domain.Repository
import com.zerir.networking.domain.model.PlanetsResponse
import com.zerir.networking.network.AsyncCall
import com.zerir.networking.network.Resource

class RepositoryImpl : Repository, AsyncCall {

    override suspend fun getAllPlanets(): Resource<PlanetsResponse> = invokeAsyncCall {
        TODO("Not yet implemented")
    }

}