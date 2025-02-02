package com.jimmy.citystore.screens.kids
data class KidsUiState(
    var garmentItem: GarmentItem = GarmentItem("", 0.0, "", 0.0, 0),
    var isImportedSelected: Boolean = true,
    var isNationalSelected: Boolean = false,
    var isSizeSelected: Boolean = false,
    var isSizeLoading: Boolean = false,
    val sizes: List<Size> = listOf(
        Size("6-7", "Length: 60 cm", "Width: 40 cm"),
        Size("8-9", "Length: 65 cm", "Width: 42 cm"),
        Size("10-11", "Length: 70 cm", "Width: 44 cm"),
        Size("12-13", "Length: 75 cm", "Width: 46 cm")
    ),
    val selectedSize: Size = Size("6-7", "Length: 60 cm", "Width: 40 cm")
)
