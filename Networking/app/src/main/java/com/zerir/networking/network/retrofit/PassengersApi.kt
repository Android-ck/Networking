package com.zerir.networking.network.retrofit

import com.zerir.networking.domain.model.PassengersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PassengersApi {

    @GET("passenger/")
    suspend fun getPassengers(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): PassengersResponse

}