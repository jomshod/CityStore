package com.jimmy.citystore.screens.homeScreen

import com.jimmy.citystore.R
import com.jimmy.citystore.navigation.AppScreens

data class Store(
    val name: String,
    val description: String,
    val image: Int,
    val route: String = ""
)

val cityStores = listOf(
    Store("General Store", "Everyday essentials and more under one roof.", R.drawable.g_s,
        AppScreens.GeneralStore.route),
    Store("Kids Store", "Quality clothing and accessories for children.", R.drawable.kids_mart,AppScreens.KidsStore.route),
    Store("Gents Store", "Men's fashion and essentials all in one place.", R.drawable.gents_mart,AppScreens.GentsStore.route),
    Store("Ladies Store", "Trendy styles and must-haves for women.", R.drawable.ladies_mart,AppScreens.LadiesStore.route),
    Store("Electronics", "Find the latest gadgets and tech here.", R.drawable.electronics_mart,AppScreens.Electronics.route)
)
