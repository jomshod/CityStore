package com.jimmy.citystore.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jimmy.citystore.navigation.AppScreens
import com.jimmy.citystore.ui.theme.CityStoreTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        StoreCard(navController = navController)


    }
}

@Composable
fun StoreCard(navController: NavController) {
    Card(
        modifier = Modifier
            .clickable { navController.navigate(AppScreens.GeneralStore.route) }
            .fillMaxWidth(),
    ) {
        Text("GeneralStore", modifier = Modifier.align(Alignment.CenterHorizontally))
        Text("GeneralStore")
        Text("GeneralStore")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    CityStoreTheme {
        HomeScreen(navController = rememberNavController())
    }
}