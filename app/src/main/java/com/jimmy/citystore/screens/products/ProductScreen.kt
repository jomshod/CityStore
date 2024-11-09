package com.jimmy.citystore.screens.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreUiState
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel
import com.jimmy.citystore.screens.generalStoreScreen.Product

@Composable
fun ProductScreen(modifier: Modifier = Modifier, vm: GeneralStoreViewModel,navController: NavController,generalStoreUiState: GeneralStoreUiState) {
    ProductItemList(products = generalStoreUiState.products)
}

@Composable
fun ProductItemList(modifier: Modifier = Modifier,products: List<Product>) {
    Column {
        LazyColumn {
            items(products){ ProductItem(product = it)}
        }
    }
}

@Composable
fun ProductItem(modifier: Modifier = Modifier,product: Product) {
    Text(text = "name:  ${product.name}")
    Text(text = "price:  ${product.price}")

}