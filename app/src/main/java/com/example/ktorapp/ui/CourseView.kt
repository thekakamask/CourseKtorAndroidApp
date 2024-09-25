package com.example.ktorapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.ktorapp.model.Course

//Composable qui affiche les détails d'un cours.
// Il reçoit un objet Course en paramètre et affiche le titre, le niveau, et l'état
// (actif/inactif) du cours. Ce composable est utilisé dans MainActivity pour
// afficher les détails du cours une fois récupéré via l'API.

@Composable
fun CourseView(course: Course) {
    Column {
        Text(text = "Titre: ${course.title}")
        Text(text = "Niveau: ${course.lvl}")
        Text(text = if (course.isActive) "Actif" else "Inactif")
    }
}