package com.jimmy.citystore.gents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GentsStoreScreen(modifier: Modifier = Modifier) {
    Scaffold {
        Column(modifier = modifier.padding(it)) {
            Text(text = "Gents Store")
            Text("Contact Us To Take this Store")
        }
    }
}