package com.nqmgaming.kotlin.lab5

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
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

        var selected by remember { mutableStateOf(false) }

        var categories by remember {
            mutableStateOf(
                listOf(
                    Category("Food", selected),
                    Category("Drinks", selected),
                    Category("Desserts", selected),
                    Category("Snacks", selected),
                    Category("Others", selected)
                )
            )
        }

        var categoriesSpot by remember {
            mutableStateOf(
                listOf(
                    Category("Football", selected),
                    Category("Basketball", selected),
                    Category("Volleyball", selected),
                    Category("Tennis", selected),
                    Category("Others", selected)
                )
            )
        }
        
        var categoriesShoes by remember {
            mutableStateOf(
                listOf(
                    Category("Nike", selected),
                    Category("Adidas", selected),
                    Category("Puma", selected),
                    Category("Reebok", selected),
                    Category("Others", selected)
                )
            )
        }

        Text(text = "Choose a category")
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            categories.forEach { category ->
                FilterChipApp(
                    label = category.name,
                    selected = category.selected,
                    onSelectedChange = {
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
        Text(text = "Choose a category")
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            categoriesSpot.forEach { category ->
                FilterChipApp2(
                    label = category.name,
                    selected = category.selected,
                    onSelectedChange = {
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
        Text(text = "Choose a category")
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            categoriesShoes.forEach { category ->
                FilterChipApp3(
                    label = category.name,
                    selected = category.selected,
                    onSelectedChange = {
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
            containerColor = if (selected) Color(0xFFE0F7FA) else Color(0xFFE0F7FA),
        ),
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FilterChipApp3(
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