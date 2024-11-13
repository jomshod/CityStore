package com.jimmy.citystore.screens.homescreen

import com.jimmy.citystore.screens.homeScreen.Store

data class HomeUiState(
    val stores: List<Store> = emptyList(),
    val route: String = ""
)
