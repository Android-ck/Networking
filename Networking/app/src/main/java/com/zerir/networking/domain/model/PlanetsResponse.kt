package com.zerir.networking.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PlanetsResponse(
    val count: Int = 0,
    val next: String?,
    val previous: String?,
    val results: List<Planet> = listOf(),
)
