package com.nqmgaming.kotlin.lab4

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesScreen() {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Add note", Toast.LENGTH_SHORT).show()
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add note",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) {
        Column {
            NotesList()
        }
    }
}

@Composable
private fun NotesList() {
    LazyColumn {
        items(notes.size) { index ->
            NotesItem(
                title = notes[index].title,
                description = notes[index].description
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NotesItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        onClick = {
            isExpanded = !isExpanded
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = title, style = TextStyle(fontSize = 20.sp))
                if (isExpanded) {
                    Text(
                        text = description,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .animateContentSize(),
                    )
                }

            }
            IconButton(onClick = {
                isExpanded = !isExpanded
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Show description",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewNotesScreen() {
    NotesScreen()
}

@Preview(showSystemUi = true)
@Composable
fun PreviewNotesList() {
    NotesList()
}

@Preview(showSystemUi = false)
@Composable
fun PreviewNotesItem() {
    NotesItem(
        title = "Title",
        description = "Description"
    )
}

data class Note(
    val title: String,
    val description: String
)

// create list of notes with title and description real data not dummy data
val notes = listOf(
    Note(
        title = "Họp nhóm dự án",
        description = "Họp nhóm dự án vào lúc 10 giờ sáng ngày mai để thảo luận về tiến độ công việc."
    ),
    Note(
        title = "Hạn nộp báo cáo",
        description = "Hạn cuối cùng để nộp báo cáo dự án là ngày 30 tháng 12."
    ),
    Note(
        title = "Cuộc họp với khách hàng",
        description = "Cuộc họp với khách hàng ABC vào lúc 2 giờ chiều ngày 15 để thảo luận về yêu cầu mới."
    ),
)