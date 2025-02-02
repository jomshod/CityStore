package com.jimmy.citystore.screens.ladies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LadiesStoreScreen(modifier: Modifier = Modifier) {
    Scaffold {
        Column(modifier = modifier.padding(it)) {
            Text(text = "Ladies Store")
            Text("Contact Us To Take this Store")
        }
    }
}