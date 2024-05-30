package com.nqmgaming.kotlin.lab5

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryChips() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Category Chips")
        SuggestionChip(
            onClick = { Log.d("CategoryChips", "SuggestionChip clicked") },
            label = { Text("Need help?") }
        )

        var selectedFood by remember { mutableStateOf(false) }
        var selectedSpot by remember { mutableStateOf(false) }
        var selectedShoes by remember { mutableStateOf(false) }

        var categories by remember {
            mutableStateOf(
                listOf(
                    Category("Food", selectedFood),
                    Category("Drinks", selectedFood),
                    Category("Desserts", selectedFood),
                    Category("Snacks", selectedFood),
                    Category("Others", selectedFood)
                )
            )
        }

        var categoriesSpot by remember {
            mutableStateOf(
                listOf(
                    Category("Football", selectedSpot),
                    Category("Basketball", selectedSpot),
                    Category("Volleyball", selectedSpot),
                    Category("Tennis", selectedSpot),
                    Category("Others", selectedSpot)
                )
            )
        }

        var categoriesShoes by remember {
            mutableStateOf(
                listOf(
                    Category("Nike", selectedShoes),
                    Category("Adidas", selectedShoes),
                    Category("Puma", selectedShoes),
                    Category("Reebok", selectedShoes),
                    Category("Others", selectedShoes)
                )
            )
        }

        Text(text = "Choose some food")
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            categories.forEach { category ->
                FilterChipApp(
                    label = category.name,
                    selected = category.selected,
                    onSelectedChange = { it ->
                        category.selected = it
                        categories = categories.map {
                            if (it.name == category.name) Category(
                                it.name,
                                it.selected
                            ) else it
                        }
                    }
                )
            }
        }
        Text(text = "Choose some sports")
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            categoriesSpot.forEach { category ->
                FilterChipApp2(
                    label = category.name,
                    selected = category.selected,
                    onSelectedChange = { it ->
                        category.selected = it
                        categoriesSpot = categoriesSpot.map {
                            if (it.name == category.name) Category(
                                it.name,
                                it.selected
                            ) else it
                        }
                    }
                )
            }
        }
        Text(text = "Choose some shoes")
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            categoriesShoes.forEach { category ->
                FilterChipApp3(
                    label = category.name,
                    selected = category.selected,
                    onSelectedChange = { it ->
                        category.selected = it
                        categoriesShoes = categoriesShoes.map {
                            if (it.name == category.name) Category(
                                it.name,
                                it.selected
                            ) else it
                        }
                    },
                    onItemDelete = {
                        categoriesShoes = categoriesShoes.filter { it.name != category.name }
                    }
                )
            }
        }

        val originalCategoriesShoes = listOf(
            Category("Nike", false),
            Category("Adidas", false),
            Category("Puma", false),
            Category("Reebok", false),
            Category("Others", false)
        )

        Button(
            onClick = {
                categories = categories.map { Category(it.name, false) }
                categoriesSpot = categoriesSpot.map { Category(it.name, false) }
                categoriesShoes = originalCategoriesShoes
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .height(50.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFda4c56),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Reset", style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            ))
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FilterChipApp(
    label: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
) {
    FilterChip(
        onClick = {
            onSelectedChange(!selected)
        },
        label = { Text(label) },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        modifier = Modifier.padding(4.dp),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FilterChipApp2(
    label: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
) {
    FilterChip(
        onClick = {
            onSelectedChange(!selected)
        },
        label = { Text(label) },
        selected = selected,
        modifier = Modifier.padding(4.dp),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = if (selected) Color.Gray else Color(0xFFE0F7FA),
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FilterChipApp3(
    label: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    onItemDelete: () -> Unit
) {
    FilterChip(
        onClick = {
            onItemDelete()
        },
        label = { Text(label) },
        selected = selected,
        modifier = Modifier.padding(4.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Clear,
                contentDescription = "Settings icon",
                modifier = Modifier.size(FilterChipDefaults.IconSize),
                tint = Color.Gray
            )
        }
    )
}

class Category(val name: String, var selected: Boolean)


@Preview(showSystemUi = true)
@Composable
fun CategoryChipsPreview() {
    CategoryChips()
}