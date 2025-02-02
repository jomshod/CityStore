package com.jimmy.citystore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jimmy.citystore.screens.cartScreen.CartScreen
import com.jimmy.citystore.screens.cartScreen.CartScreenViewModel
import com.jimmy.citystore.screens.cartScreen.CheckOutScreen
import com.jimmy.citystore.screens.detailScreen.DetailScreen
import com.jimmy.citystore.screens.elctronics.ElectronicsStoreScreen
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreScreen
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel
import com.jimmy.citystore.screens.gents.GentsStoreScreen
import com.jimmy.citystore.screens.homescreen.HomeScreen
import com.jimmy.citystore.screens.homescreen.HomeViewModel
import com.jimmy.citystore.screens.kids.GarmentDetailsScreen
import com.jimmy.citystore.screens.kids.KidsGarmentsScreen
import com.jimmy.citystore.screens.kids.KidsStoreScreen
import com.jimmy.citystore.screens.kids.KidsViewModel
import com.jimmy.citystore.screens.ladies.LadiesStoreScreen
import com.jimmy.citystore.screens.products.ProductScreen
import com.jimmy.citystore.screens.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val vm = hiltViewModel<GeneralStoreViewModel>()
    val cvm = hiltViewModel<CartScreenViewModel>()
    val hvm = hiltViewModel<HomeViewModel>()
    val kvm = hiltViewModel<KidsViewModel>()
    val generalStoreUiState by vm.generalStoreUiState.collectAsState()
    val cartUiState by cvm.cartUiState.collectAsState()
    val homeUiState by hvm.homeUiState.collectAsState()
    val kidsUiState by kvm.kidsUiState.collectAsState()
    NavHost(navController = navController, startDestination = AppScreens.Splash.route) {
        composable(AppScreens.Splash.route) { SplashScreen(navController = navController) }
        composable(AppScreens.Home.route) {
            HomeScreen(
                navController = navController,
                hvm = hvm,
                homeUiState = homeUiState,
                vm = vm

            )
        }
        composable(AppScreens.GeneralStore.route) {
            GeneralStoreScreen(
                navController = navController,
                vm = vm,
                generalStoreUiState = generalStoreUiState
            )
        }
        composable(AppScreens.Cart.route) {
            CartScreen(
                navController = navController,
                vm = vm,
                cvm = cvm,
                cartUiState = cartUiState
            )
        }
        composable(AppScreens.DetailScreen.route) {
            DetailScreen(
                item = generalStoreUiState.item,
                vm = vm,
                navController,
                cvm = cvm
            )
        }
        composable(AppScreens.Products.route) {
            ProductScreen(
                modifier = Modifier,
                vm = vm,
                navController,
                generalStoreUiState
            )
        }
        composable(AppScreens.KidsStore.route) {
            KidsStoreScreen(
                navController = navController,
                kvm = kvm,
                kidsUiState = kidsUiState
            )
        }
        composable(AppScreens.GentsStore.route) { GentsStoreScreen() }
        composable(AppScreens.LadiesStore.route) { LadiesStoreScreen() }
        composable(AppScreens.Electronics.route) { ElectronicsStoreScreen() }
        composable(AppScreens.GarmentStore.route) {
           KidsGarmentsScreen(
                navController = navController, kvm = kvm, kidsUiState = kidsUiState,

                )
        }
        composable(AppScreens.GarmentDetailsScreen.route) {
            GarmentDetailsScreen(
                kvm = kvm, kidsUiState = kidsUiState
            )
        }
        composable(AppScreens.CheckOutScreen.route) { CheckOutScreen(navController=navController) }

    }
}

