package com.jimmy.citystore.screens.kids

import com.jimmy.citystore.R

data class GarmentItem(
    val name: String,
    val price: Double,
    val sizeRange: String,
    val originalPrice: Double,
    val imageUrl: Int
)
val garmentItems = listOf(
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart),
    GarmentItem("Shirt", 1999.0, "8-12 years",2499.0,R.drawable.kids_mart)



)