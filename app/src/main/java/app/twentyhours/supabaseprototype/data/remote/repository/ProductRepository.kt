package app.twentyhours.supabaseprototype.data.remote.repository

import app.twentyhours.supabaseprototype.data.remote.dto.ProductDto
import app.twentyhours.supabaseprototype.domain.model.Product

interface ProductRepository {
    suspend fun createProduct(product: Product): Boolean
    suspend fun getProducts(): List<ProductDto>
    suspend fun getProduct(id: String): ProductDto
}