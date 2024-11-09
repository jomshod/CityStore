package com.jimmy.citystore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jimmy.citystore.screens.cartScreen.CartScreen
import com.jimmy.citystore.screens.cartScreen.CartScreenViewModel
import com.jimmy.citystore.screens.detailScreen.DetailScreen
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreScreen
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel
import com.jimmy.citystore.screens.homeScreen.HomeScreen
import com.jimmy.citystore.screens.products.ProductScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val vm: GeneralStoreViewModel = viewModel()
    val cvm: CartScreenViewModel = viewModel()
    val generalStoreUiState by vm.homeUiState.collectAsState()
    val cartUiState by cvm.cartUiState.collectAsState()
    NavHost(navController = navController, startDestination = AppScreens.Home.route) {
        composable(AppScreens.Home.route) { HomeScreen(navController = navController) }
        composable(AppScreens.GeneralStore.route) {GeneralStoreScreen(navController = navController, vm = vm, generalStoreUiState = generalStoreUiState) }
        composable(AppScreens.Cart.route) { CartScreen(navController = navController, vm = vm, cvm = cvm, cartUiState = cartUiState) }
        composable(AppScreens.DetailScreen.route){ DetailScreen(item = generalStoreUiState.item, vm=vm,navController,cvm=cvm) }
        composable(AppScreens.Products.route){ ProductScreen( modifier = Modifier, vm = vm,navController,generalStoreUiState)}

    }
}



//GeneralStoreScreen(navController = navController, vm = vm, generalStoreUiState = generalStoreUiState)
sealed class AppScreens(val route: String) {
    data object Test : AppScreens("test")
    data object Home : AppScreens("home")
    data object GeneralStore: AppScreens("generalStore")
    data object Cart : AppScreens("cart")
    data object Products : AppScreens("products")
    data object DetailScreen : AppScreens("detailScreen")
}

