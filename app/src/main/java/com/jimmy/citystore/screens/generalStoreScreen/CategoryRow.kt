package com.jimmy.citystore.screens.generalStoreScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
@Composable
fun CategoryRow(
    categories: List<Category>,
    selectedCategory: Category?,
    onCategorySelected: (Category) -> Unit,
    onAllClick: () -> Unit,
) {
    LazyRow(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)) {
        // All button
        item {
            val isSelected = selectedCategory == null
            Text(
                text = "All",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else Color.Gray
                ),
                modifier = Modifier
                    .clickable { onAllClick() }

            )
            Spacer(modifier = Modifier.width(16.dp))
        }

        // Category items
        items(categories) { category ->
            val isSelected = selectedCategory == category
            CategoryItem(category, isSelected, onCategorySelected)
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    isSelected: Boolean,
    onCategorySelected: (Category) -> Unit
) {
    Text(
        text = category.name,
        softWrap = true,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier
            .clickable { onCategorySelected(category) }
    )
    Spacer(modifier = Modifier.width(16.dp))
}


val beauty = Category(
    "Beauty",
    listOf(SubCategory("Cream"), SubCategory("FaceWash"), SubCategory("Lipstick"))
)
val hygiene = Category(
    "Hygiene", listOf(
        SubCategory("Soap"), SubCategory("Shampoo"),
        SubCategory("Devtool")
    )
)
val houseHold = Category(
    "House Hold", listOf(
        SubCategory("Detergent"), SubCategory("Dishwash"),
        SubCategory("viper")
    )
)
val food = Category("Food", listOf(SubCategory("Rice"), SubCategory("Beans"), SubCategory("Rice")))

val categories = listOf(
    beauty, hygiene, houseHold, food
)

data class Category(
    val name: String,
    val subCategories: List<SubCategory> = emptyList()
)

data class SubCategory(val name: String)