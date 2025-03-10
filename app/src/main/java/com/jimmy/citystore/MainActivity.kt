package com.jimmy.citystore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jimmy.citystore.navigation.AppNavigation
import com.jimmy.citystore.ui.theme.CityStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CityStoreTheme {
                CityStoreApp()
            }
        }
    }
}

@Composable
fun CityStoreApp(modifier: Modifier = Modifier) {
    AppNavigation()
}

