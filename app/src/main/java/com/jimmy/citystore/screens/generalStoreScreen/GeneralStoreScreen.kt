package com.jimmy.citystore.screens.generalStoreScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jimmy.citystore.ItemCard
import com.jimmy.citystore.navigation.AppScreens
import com.jimmy.citystore.screens.homescreen.CartIcon
import com.jimmy.citystore.screens.homescreen.MoreIcon

@Composable
fun GeneralStoreScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: GeneralStoreViewModel,
    generalStoreUiState: GeneralStoreUiState
) {

    val scrollState = rememberLazyGridState()

    // Control the visibility of the TopAppBar based on scroll position
    val isTopBarVisible by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex == 0 &&
                    scrollState.firstVisibleItemScrollOffset == 0
        }
    }

    Scaffold(
        topBar = {
            if (isTopBarVisible) {
                CityStoreTopAppBar(
//                    onCartClick = { navController.navigate(AppScreens.Cart.route) },
                    title = "City Store",
//                    vm = vm,navController=navController
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {

            // Category row (pass null for "All" click)
            CategoryRow(
                categories = categories,
                onCategorySelected = {
                    vm.onCategorySelected(it)
                },
                onAllClick = { vm.onAllClick() }, selectedCategory = generalStoreUiState.selectedCategory
            )

            // Show subcategories if a category is selected
            if (generalStoreUiState.isCategorySelected) {
                SubCategoryRow(
                    subCategories = generalStoreUiState.subCategories,
                    selectedSubCategory = generalStoreUiState.selectedSubCategory,
                    onSubCategorySelected = { subCategory ->
                        vm.onSubCategorySelected(subCategory) // Filter by subcategory
                    }
                )
            }

            // Display filtered items
            GeneralStoreContent(
                items = generalStoreUiState.homeItems,
                onItemClick = {
                    vm.updateItem(it)
                    navController.navigate(AppScreens.DetailScreen.route)
                },
                scrollState = scrollState
            )
        }
    }
}


@Composable
fun  GeneralStoreContent(

    items: List<Item>,
    onItemClick: (Item) -> Unit,
    scrollState: LazyGridState
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp) // Compact padding
            .fillMaxHeight(),
        state = scrollState
    ) {
        items(items) { item ->
            ItemCard(item, onItemClick)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityStoreTopAppBar(
    title: String,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
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



