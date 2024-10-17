package app.twentyhours.supabaseprototype.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: String? = "",
    val name: String,
    val price: Double,
    val image: String? = ""
)