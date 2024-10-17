package app.twentyhours.supabaseprototype.domain.model

data class Product (
    val id: String? = "",
    val name: String,
    val price: Double,
    val image: String? = ""
)