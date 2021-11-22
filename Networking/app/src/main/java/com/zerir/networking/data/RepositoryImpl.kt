package com.zerir.networking.data

import com.zerir.networking.domain.Repository
import com.zerir.networking.domain.model.PassengersResponse
import com.zerir.networking.network.AsyncCall
import com.zerir.networking.network.Resource
import com.zerir.networking.network.retrofit.PassengersApi

class RepositoryImpl(private val passengersApi: PassengersApi) : Repository, AsyncCall {

    override suspend fun getAllPassengers(): Resource<PassengersResponse> = invokeAsyncCall {
        passengersApi.getPassengers(page = 0, size = 100)
    }

}