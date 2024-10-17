package app.twentyhours.supabaseprototype.domain.usecase.impl

import app.twentyhours.supabaseprototype.data.remote.repository.ProductRepository
import app.twentyhours.supabaseprototype.domain.usecase.CreateProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
): CreateProductUseCase {
    override suspend fun execute(input: CreateProductUseCase.Input): CreateProductUseCase.Output {
        return try {
            withContext(Dispatchers.IO) {
                val result = productRepository.createProduct(product = input.product)
                if (result) {
                    CreateProductUseCase.Output.Success(result = true)
                } else {
                    CreateProductUseCase.Output.Failure()
                }
            }
        } catch (e: Exception) {
            CreateProductUseCase.Output.Failure.Conflict
        }
    }
}