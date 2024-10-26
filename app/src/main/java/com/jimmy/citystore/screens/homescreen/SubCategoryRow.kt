package com.jimmy.citystore.screens.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun SubCategoryRow(
    subCategories: List<SubCategory>,
    selectedSubCategory: SubCategory?,
    onSubCategorySelected: (SubCategory) -> Unit
) {
    LazyRow(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 2.dp)) {
        items(subCategories) {
            val isSelected = selectedSubCategory == it
            SubCategoryItem(it, isSelected ,onSubCategorySelected)
        }
    }
}

@Composable
fun SubCategoryItem(
    subCategory: SubCategory,
    isSelected: Boolean,
    onSubCategorySelected: (subCategory: SubCategory) -> Unit
) {
    Text(
        text = subCategory.name, style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Bold,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary
        ),
        modifier = Modifier.clickable { onSubCategorySelected(subCategory) }
    )
    Spacer(modifier = Modifier.width(16.dp))

}