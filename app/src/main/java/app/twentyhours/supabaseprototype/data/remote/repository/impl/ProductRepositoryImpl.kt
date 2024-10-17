package app.twentyhours.supabaseprototype.data.remote.repository.impl

import app.twentyhours.supabaseprototype.data.remote.dto.ProductDto
import app.twentyhours.supabaseprototype.domain.model.Product
import app.twentyhours.supabaseprototype.data.remote.repository.ProductRepository
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
): ProductRepository {
    override suspend fun createProduct(product: Product): Boolean {
        val productDto = ProductDto(
            name = product.name,
            price = product.price,
        )
        postgrest["products"].insert(productDto)
        return true
    }

    override suspend fun getProducts(): List<ProductDto> {
        return postgrest["products"].select().decodeList()
    }

    override suspend fun getProduct(id: String): ProductDto {
        return postgrest["products"].select {
            filter {
                eq("id", id)
            }
        }.decodeSingle()
    }
}