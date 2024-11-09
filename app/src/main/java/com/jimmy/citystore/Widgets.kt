package com.jimmy.citystore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jimmy.citystore.screens.generalStoreScreen.Item

@Composable
fun ItemCard(item:Item, onItemClick: (Item) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth().clickable { onItemClick(item) },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            AsyncImage(
                model = item.photos["image1"]?:item.image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(100.dp)

            )

            Spacer(modifier = Modifier.height(2.dp))
            PriceRow(item = item)

        }
    }
}

@Composable
fun PriceRow(item: Item) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Retail Price:",
                style = TextStyle(fontSize = 12.sp),
                color = MaterialTheme.colorScheme.onSurface
            )
            CutPrice(text = item.marketPrice, modifier = Modifier.size(20.dp, 0.dp))
        }

        Spacer(modifier = Modifier.width(28.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Our Price:", style = TextStyle(fontSize = 12.sp))
            Text(text = item.ourPrice, style = TextStyle(fontSize = 12.sp))
        }
        Spacer(modifier = Modifier.width(4.dp))

    }
}

@Composable
fun CutPrice(text: String, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = TextStyle(fontSize = 12.sp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Red,
            modifier = modifier
        )
    }
}