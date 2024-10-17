package app.twentyhours.supabaseprototype.presentation.features.addproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.twentyhours.supabaseprototype.domain.model.Product
import app.twentyhours.supabaseprototype.domain.usecase.CreateProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val createProductUseCase: CreateProductUseCase
) : ViewModel() {

    fun onCreateProduct(name: String, price: Double) {
        if (name.isEmpty() || price <= 0.0) return
        viewModelScope.launch {
            createProductUseCase.execute(
                CreateProductUseCase.Input(
                    product = Product(
                        name = name,
                        price = price
                    )
                )
            )
        }
    }
}