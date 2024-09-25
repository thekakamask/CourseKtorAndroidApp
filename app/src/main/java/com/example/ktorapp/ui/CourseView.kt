package com.example.ktorapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.ktorapp.model.Course


@Composable
fun CourseView(course: Course) {
    Column {
        Text(text = "Titre: ${course.title}")
        Text(text = "Niveau: ${course.lvl}")
        Text(text = if (course.isActive) "Actif" else "Inactif")
    }
}

//The CourseView function is a Jetpack Compose composable that takes a Course object
//as input and displays its information in a structured way in a column.

//Here are the main actions of this function:
//-Course title display: The first line displays the course title with the words
//“Title: ”.
//-Course level display: The second line displays the course level (lvl).
//-Course status display: The third line shows whether the course is “Active” or
//“Inactive”, according to the Boolean value isActive.