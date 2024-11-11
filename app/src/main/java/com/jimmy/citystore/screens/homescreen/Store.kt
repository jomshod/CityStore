package com.jimmy.citystore.screens.homeScreen

import com.jimmy.citystore.R

data class Store(
    val name: String,
    val description: String,
    val image: Int
)

val cityStores = listOf(
    Store("Kids Store", "You can buy Child clothes here", R.drawable.kids_mart),
    Store("Gents Store", "You can buy Child clothes here", R.drawable.gents_mart),
    Store("Ladies Store", "You can buy Child clothes here", R.drawable.ladies_mart),
    Store("Electronics", "You can buy Child clothes here", R.drawable.electronics_mart)
)
