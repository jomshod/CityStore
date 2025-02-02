package com.jimmy.citystore.screens.kids

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun GarmentDetailsScreen(
    modifier: Modifier = Modifier,
    kidsUiState: KidsUiState,
    kvm: KidsViewModel
) {
    Scaffold { it ->
        Column(modifier.padding(it)) {
            Text(
                text = kidsUiState.garmentItem.name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(kidsUiState.garmentItem.imageUrl), null
            )
            Text(
                text = "Choose a size as per age", modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), textAlign = TextAlign.Center
            )
            SizeButtonList(kidsUiState, kvm)
            SizeDetails(
                selectedSize = kidsUiState.selectedSize,
                isLoading = kidsUiState.isSizeLoading
            )
            Button(
                onClick = {}, shape = RectangleShape, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) { Text("Add To Cart") }
        }
    }
}

@Composable
fun SizeButtonList(
    kidsUiState: KidsUiState,
    kvm: KidsViewModel,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(8.dp),
    ) {
        items(kidsUiState.sizes) { size ->
            SizeButton(
                size,
                isSizeSelected = size == kidsUiState.selectedSize,
                { kvm.onSizeClick(size) })
        }
    }
}

@Composable
fun SizeButton(size: Size, isSizeSelected: Boolean, onSizeSelected: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onSizeSelected() },
        shape = RoundedCornerShape(24.dp),
        color = if (isSizeSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Text(
            size.ageRange, modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp), textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SizeDetails(selectedSize: Size, isLoading: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Column {
                Text(
                    text = "Size Details:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = selectedSize.length,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = selectedSize.width,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}

data class Size(val ageRange: String, val length: String, val width: String)

//
//@Preview(showBackground = true)
//@Composable
//private fun GarmentDetailPreview() {
//    CityStoreTheme {
//        val fakeKidsUiState = KidsUiState(
//            garmentItem = GarmentItem("Shirt", 1999.0, "8-12 years", 2499.0, R.drawable.kids_mart),
//            selectedSize = Size("8-9", "Length: 65 cm", "Width: 42 cm")
//        )
//
//        // Mock ViewModel
//        val fakeViewModel = object : KidsViewModel() {
//            override val kidsUiState = MutableStateFlow(fakeKidsUiState).asStateFlow()
//        }
//
//        GarmentDetailsScreen(
//            modifier = Modifier,
//            kidsUiState = fakeViewModel.kidsUiState.value,
//            kvm = fakeViewModel
//        )
//    }
//}
