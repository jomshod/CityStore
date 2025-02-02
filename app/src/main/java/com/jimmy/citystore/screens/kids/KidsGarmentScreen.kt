package com.jimmy.citystore.screens.kids

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jimmy.citystore.navigation.AppScreens
import com.jimmy.citystore.ui.theme.CityStoreTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KidsGarmentsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    kvm: KidsViewModel,
    kidsUiState: KidsUiState
) {
    Scaffold(topBar = { CenterAlignedTopAppBar({ Text("Kids Garments") }) }) {
        Column(modifier.padding(it)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {

                items(garmentItems) { garmentItem ->
                    KidsItemCard(
                        garmentItem = garmentItem,
                        onGarmentCardClicked = {
                            kvm.updateGarmentItem(garmentItem)
                            navController.navigate(AppScreens.GarmentDetailsScreen.route)
                        })
                }
            }
        }


    }
}

@Composable
fun KidsItemCard(
    modifier: Modifier = Modifier,
    garmentItem: GarmentItem,
    onGarmentCardClicked: (GarmentItem) -> Unit
) {


    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onGarmentCardClicked(garmentItem) },

        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Image(
            painter = painterResource(id = garmentItem.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentScale = ContentScale.Crop
        )

        // Available For and Button Row
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    text = "sizes",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = garmentItem.sizeRange,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold
                )
            }
            PriceTag(
                modifier = Modifier
                    .padding(), garmentItem
            )
        }


    }
}


@Composable
fun PriceTag(modifier: Modifier, garmentItem: GarmentItem) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = garmentItem.price.toString(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.error
            )
        )
        Text(
            text = garmentItem.originalPrice.toString(),
            style = TextStyle(
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textDecoration = TextDecoration.LineThrough
            )
        )
    }
}

