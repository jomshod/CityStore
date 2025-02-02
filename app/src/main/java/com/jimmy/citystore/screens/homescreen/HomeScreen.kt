package com.jimmy.citystore.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jimmy.citystore.R
import com.jimmy.citystore.navigation.AppScreens
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel
import com.jimmy.citystore.screens.homeScreen.Store
import com.jimmy.citystore.screens.homeScreen.cityStores
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    hvm: HomeViewModel,
    homeUiState: HomeUiState,
    vm:GeneralStoreViewModel
) {
    Scaffold(
        topBar = {
            HomeTopBar(
            navController = navController,
            vm = vm
        ) },
        containerColor = MaterialTheme.colorScheme.primary
    ) { paddingValues ->
        StoreList(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues),
            navController = navController,
            hvm = hvm,
            homeUiState = homeUiState
        )
    }


}


@Composable
fun StoreList(
    modifier: Modifier = Modifier,
    stores: List<Store> = cityStores,
    navController: NavController,
    hvm: HomeViewModel,
    homeUiState: HomeUiState

) {
    Box {
        LazyColumn(modifier = modifier) {
            items(stores) {
                StoreCard(
                    modifier = Modifier,
                    onStoreClick = { hvm.updateRoute(it.route) },
                    store = it
                )

            }
        }
        if (homeUiState.isNavigating) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp).align(Alignment.Center),
                color = MaterialTheme.colorScheme.primaryContainer,
                trackColor = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
    // LaunchedEffect to handle the delay and navigation
    LaunchedEffect(homeUiState.route, homeUiState.isNavigating) {
        if (homeUiState.isNavigating && homeUiState.route.isNotEmpty()) { // Ensure the route is set and loading is active
            delay(1500L) // Delay for 1 second
            navController.navigate(homeUiState.route) // Navigate to the route
            hvm.resetHome()

        }
    }

}

@Composable
fun StoreCard(
    modifier: Modifier,
    onStoreClick: () -> Unit,
    store: Store = Store(
        "Kids Store",
        "You can buy Child clothes here",
        R.drawable.kids_mart
    )
) {
    Card(
        modifier = modifier
            .clickable { onStoreClick() }
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(2.dp)

    ) {
        Row {
            Image(
                painter = painterResource(id = store.image),
                contentDescription = "General Store",
                modifier = Modifier.size(130.dp)
            )
            Column {
                Text(
                    store.name,
                    style = TextStyle(
                        fontFamily = MaterialTheme.typography.displayMedium.fontFamily
                    ),
                    fontSize = 24.sp
                )
                Text(
                    store.description,
                    style = TextStyle(
                        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(navController: NavController,vm:GeneralStoreViewModel) {
    TopAppBar(
        title = {

            Text(
                "City Store",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontFamily = MaterialTheme.typography.displaySmall.fontFamily,
                    fontWeight = FontWeight.ExtraBold
                )
            )

        },
        actions = {
            CartIcon(onCartClick = { navController.navigate(AppScreens.Cart.route)}, vm = vm)
            Spacer(modifier = Modifier)
            MoreIcon {}
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

