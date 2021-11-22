package com.zerir.networking.domain

import com.zerir.networking.domain.model.PassengersResponse
import com.zerir.networking.network.Resource

interface Repository {

    suspend fun getAllPassengers(): Resource<PassengersResponse>

}