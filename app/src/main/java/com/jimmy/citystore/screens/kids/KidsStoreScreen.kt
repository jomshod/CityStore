package com.jimmy.citystore.screens.kids

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jimmy.citystore.navigation.AppScreens

@Composable
fun KidsStoreScreen(modifier: Modifier = Modifier, navController: NavController,kvm: KidsViewModel, kidsUiState: KidsUiState) {
    Scaffold(
        topBar = { KidsTopAppBar() },
    ) {
        Column(modifier = modifier.padding(it)) {
            NavigationTabs(modifier, kvm, kidsUiState)
            Button(
                onClick = {navController.navigate(AppScreens.GarmentStore.route)},
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) { Text("Garment Store") }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KidsTopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text("Kids Store") },
    )
}

@Composable
fun NavigationTabs(
    modifier: Modifier = Modifier,
    kvm: KidsViewModel,
    kidsUiState: KidsUiState,

    ) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

        TextButton(

            onClick = { kvm.onImportedClick() },
            colors = ButtonDefaults.textButtonColors(
                contentColor = if (kidsUiState.isImportedSelected) MaterialTheme.colorScheme.primary
                else Color.Gray
            )
        ) {
            Text(
                "Imported",
                style = TextStyle(
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.SemiBold, fontSize = 16.sp
                )
            )
        }
        TextButton(
            onClick = {
                kvm.onNationalClick()
            },
            colors = ButtonDefaults.textButtonColors(
                contentColor = if (kidsUiState.isNationalSelected) MaterialTheme.colorScheme.primary
                else Color.Gray
            )
        ) {
            Text(
                "Made in pakistan", style = TextStyle(
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.SemiBold, fontSize = 16.sp
                )
            )
        }

    }
}