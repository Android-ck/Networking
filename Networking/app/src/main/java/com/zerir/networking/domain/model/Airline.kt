package com.zerir.networking.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Airline(
    val country: String = "",
    val established: String = "",
    val head_quaters: String = "",
    val id: Long = 0,
    val logo: String = "",
    val name: String = "",
    val slogan: String = "",
    val website: String = "",
)