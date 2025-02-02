package com.jimmy.citystore.screens.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel

@Composable
fun MoreIcon(onMoreClick: () -> Unit) {
    Row(modifier = Modifier.clickable(onClick = onMoreClick)) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Cart",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(30.dp)
        )

    }
}

@Composable
fun CartIcon(onCartClick: () -> Unit, vm: GeneralStoreViewModel) {
    val homeUiState by vm.generalStoreUiState.collectAsState()
    Row(modifier = Modifier.clickable(onClick = onCartClick)) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Cart",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(30.dp)
        )
        Surface(
            shape = RoundedCornerShape(15.dp),
            color = Color.Red.copy(alpha = 0.7f),
        ) {
            Text(
                text = homeUiState.item.totalCartItems.toString(),
                modifier = Modifier.padding(2.dp),
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
    }
}