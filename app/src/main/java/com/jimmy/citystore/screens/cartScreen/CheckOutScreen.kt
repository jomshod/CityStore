package com.jimmy.citystore.screens.cartScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CheckOutScreen(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    Scaffold(topBar = { CheckOutTopBar() }) { paddingValues ->
        CheckOutLayout(modifier.padding(paddingValues),
            onPlaceOrderClick = {
                Toast.makeText(context, "Thank you for shopping", Toast.LENGTH_LONG).show()
            }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutTopBar() {
    CenterAlignedTopAppBar(
        { Text("Enter Your Details") }
    )
}

@Composable
fun CheckOutLayout(modifier: Modifier = Modifier, onPlaceOrderClick:  () -> Unit) {
    Column(modifier = modifier) {
        Text("Cash On Delivery")
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter your Name") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Phone Number") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Distric Name") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Tehsil Name") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Enter Your Adress") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        Text("total Items: 00000")
        Text("Total Price: 00000")
        Button(
            onClick = { onPlaceOrderClick() },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) { Text("Place Order", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) }
    }
}

