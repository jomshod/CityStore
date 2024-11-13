package com.jimmy.citystore.kids

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun KidsStoreScreen(modifier: Modifier = Modifier) {
    Scaffold {
        Column(modifier = modifier.padding(it)) {
            Text(text = "Kids Store")
            Text("Contact Us To Take this Store")
        }
    }
}