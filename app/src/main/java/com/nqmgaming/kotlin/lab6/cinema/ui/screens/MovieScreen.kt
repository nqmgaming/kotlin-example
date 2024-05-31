package com.nqmgaming.kotlin.lab6.cinema.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nqmgaming.kotlin.lab6.cinema.model.entities.Movie
import com.nqmgaming.kotlin.lab6.cinema.model.entities.getListMovies
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen() {
    var listType = remember { mutableStateOf(ListType.COLUMN) }
    val context = LocalContext.current
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Movies", style = MaterialTheme.typography.titleSmall)
                    },
                    actions = {
                        IconButton(onClick = { showBottomSheet = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More menu"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (listType.value) {
                    ListType.ROW -> {
                        LazyRow(
                            contentPadding = PaddingValues(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val movies = Movie().getListMovies()
                            items(movies.size) { index ->
                                MovieItem(movie = movies[index])
                            }
                        }
                    }

                    ListType.GRID -> {
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            state = rememberLazyStaggeredGridState(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalItemSpacing = 8.dp,
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            val movies = Movie().getListMovies()
                            items(movies.size) { index ->
                                MovieItem(movie = movies[index])
                            }
                        }
                    }

                    ListType.COLUMN -> {
                        LazyColumn(
                            contentPadding = PaddingValues(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val movies = Movie().getListMovies()
                            items(movies.size) { index ->
                                MovieItemVertical(movie = movies[index])
                            }

                        }
                    }
                }
            }


            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    Button(
                        onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                    listType.value = ListType.ROW
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                            .fillMaxWidth()
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
                        Text("Row")
                    }

                    Button(
                        onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                    listType.value = ListType.GRID
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                            .fillMaxWidth()
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
                        Text("Grid")
                    }

                    Button(
                        onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                    listType.value = ListType.COLUMN
                                }
                            }
                        }, modifier = Modifier
                            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 40.dp)
                            .fillMaxWidth()
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
                        Text("Column")
                    }
                }
            }
        }

    }
}

@Composable
fun MovieItem(
    movie: Movie
) {
    Card(
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = movie.poster,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(180.dp)
                    .height(255.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 8.dp,
                            topStart = 8.dp
                        )
                    )
            )
            Column {
                Text(
                    text = movie.title, style =
                    MaterialTheme.typography.titleSmall, maxLines = 1,
                    modifier = Modifier.width(180.dp),
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray
                            )
                        ) {
                            append("Duration: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("${movie.duration}")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray
                            )
                        ) {
                            append(" min")
                        }
                    }
                )

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Rating: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("${movie.rating}")
                    }
                })

            }
        }
    }
}

@Composable
fun MovieItemVertical(
    movie: Movie
) {
    Card(
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = movie.poster,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(180.dp)
                    .height(220.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 8.dp,
                            topStart = 8.dp
                        )
                    )
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = movie.title, style =
                    MaterialTheme.typography.titleSmall, maxLines = 1,
                    modifier = Modifier.width(180.dp),
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black
                            )
                        ) {
                            append("Duration: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                            )
                        ) {
                            append("${movie.duration}")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray
                            )
                        ) {
                            append(" min")
                        }
                    }
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("Rating: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                            )
                        ) {
                            append("${movie.rating}")
                        }
                    },
                    modifier = Modifier.padding(top = 3.dp)
                )

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Release Date: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                        )
                    ) {
                        append("${movie.releaseDate}")
                    }
                })

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Director: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                        )
                    ) {
                        append("${movie.director}")
                    }
                })

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Cast: ")
                    }
                    withStyle(
                        style = SpanStyle(
                        )
                    ) {
                        append("${movie.cast.joinToString()}")
                    }
                })

                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Synopsis: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray
                        )
                    ) {
                        append("${movie.synopsis}")
                    }
                },
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4
                )


            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MovieScreenPreview() {
    MovieScreen()
}