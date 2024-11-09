package com.jimmy.citystore.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jimmy.citystore.navigation.AppScreens
import com.jimmy.citystore.ui.theme.CityStoreTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(topBar = { HomeTopBar() }) { paddingValues ->
        StoreCard(
            modifier = modifier.padding(paddingValues),
            navController
        )
    }
}

@Composable
fun StoreCard(modifier: Modifier, navController: NavController) {
    Card(
        modifier = modifier
            .clickable { navController.navigate(AppScreens.GeneralStore.route) }
            .fillMaxWidth(),
    ) {
        Text("GeneralStore", modifier = Modifier.align(Alignment.CenterHorizontally))
        Text("GeneralStore")
        Text("GeneralStore")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { Text("CityStore", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    CityStoreTheme {
        HomeScreen(navController = rememberNavController())
    }
}