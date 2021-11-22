package com.zerir.networking.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PassengersResponse(
    val totalPassengers: Long = 0,
    val totalPages: Long = 0,
    val data: List<Passenger> = listOf(),
)
