package com.zerir.networking.network.ktor

import com.zerir.networking.domain.model.PassengersResponse

interface PassengersApi {

    suspend fun getPassengers(page: Int, size: Int): PassengersResponse

}