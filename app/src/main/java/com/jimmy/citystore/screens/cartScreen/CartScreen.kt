package com.jimmy.citystore.screens.cartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel
import com.jimmy.citystore.screens.generalStoreScreen.Item


@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: GeneralStoreViewModel,
    cvm: CartScreenViewModel,
    cartUiState: CartUiState
) {


    CartContent(items = cartUiState.cartItems)
}

@Composable
fun CartContent(modifier: Modifier = Modifier, items: List<Item>,
              ) {
    Scaffold(topBar = { CartAppBar() }) {
        CartITemList(
            items = items,
            modifier = modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CartAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "CityStore",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun CartITemList(
    modifier: Modifier = Modifier,
    items: List<Item>,
) {

    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn() {
            items(items) { it -> CartItemCard(it, { }, {  }) }
        }
    }

}

@Composable
fun CartItemCard(
    item: Item,
    onAddClick: (Item) -> Unit = {},
    onRemoveClick: (Item) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Item image and name
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    AsyncImage(
                        model = item.image,
                        contentDescription = item.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }

                // Quantity controls
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    FilledIconButton(onClick = { onAddClick(item) }, shape = RoundedCornerShape(8.dp)) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add one more ${item.name}"
                        )
                    }
                    FilledIconButton(
                        onClick = { onAddClick(item) }, shape = RoundedCornerShape(8.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = Color.Red
                        )
                    ) {
                        Text(
                            text = item.itemQuantity.toString(),
                            modifier = Modifier

                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            style = TextStyle(color = MaterialTheme.colorScheme.onBackground)
                        )
                    }



                    FilledIconButton(onClick = { onRemoveClick(item) }, shape = RoundedCornerShape(8.dp)) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Remove one from ${item.name}"
                        )
                    }

                }
            }
        }
    }
}
