package com.jimmy.citystore.screens.elctronics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ElectronicsStoreScreen(modifier: Modifier = Modifier) {
    Scaffold {
        Column(modifier = modifier.padding(it)) {
            Text(text = "Electronics Store")
            Text("Contact Us To Take this Store")
        }
    }
}