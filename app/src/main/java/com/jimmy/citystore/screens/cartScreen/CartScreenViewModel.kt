package com.jimmy.citystore.screens.cartScreen

import androidx.lifecycle.ViewModel
import com.jimmy.citystore.screens.generalStoreScreen.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartScreenViewModel : ViewModel() {
    private val _cartUiState = MutableStateFlow(CartUiState())
    val cartUiState: StateFlow<CartUiState> = _cartUiState.asStateFlow()
    var itemQuantity: Int = 0
    fun AddInCart(item: Item) {
        _cartUiState.value =
            _cartUiState.value.copy(cartItems = _cartUiState.value.cartItems + item)
    }
    fun increasItemByOne(item: Item) {

        _cartUiState.value = _cartUiState.value.copy(item.copy(itemQuantity = itemQuantity))
    }
}

data class CartUiState(
    val item: Item = Item(),
    val cartItems: List<Item> = emptyList(),
    val totalPrice: Double = 0.0,
    val totalItems: Int = 0

)