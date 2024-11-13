package com.jimmy.citystore.navigation



sealed class AppScreens(val route: String) {
    data object Splash : AppScreens("splash")
    data object Home : AppScreens("home")
    data object GeneralStore: AppScreens("generalStore")
    data object KidsStore : AppScreens("kidsStore")
    data object GentsStore : AppScreens("gentsStore")
    data object LadiesStore : AppScreens("ladiesStore")
    data object Electronics : AppScreens("electronics")
    data object Cart : AppScreens("cart")
    data object Products : AppScreens("products")
    data object DetailScreen : AppScreens("detailScreen")
}

