package com.example.ktorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.ktorapp.ui.theme.KtorAppTheme
import com.example.ktorapp.viewmodel.CourseViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.livedata.observeAsState
import com.example.ktorapp.ui.CourseView

//Lance l'interface utilisateur en utilisant Jetpack Compose. observe les données
// du ViewModel via LiveData pour mettre à jour l'interface.
//Le ViewModel gère la logique de récupération des données. Si les données
// sont disponibles, l'UI affiche les détails du cours via un composable CourseView.
// Si une erreur survient, un message d'erreur s'affiche, et dans le cas où rien
// n'est encore chargé, l'UI affiche un message "Loading...".

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val courseViewModel: CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorAppTheme {
                // UI Logic here, observing ViewModel data
                val topCourse = courseViewModel.topCourse.observeAsState()
                val error = courseViewModel.error.observeAsState()

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    if (topCourse.value != null) {
                        // Affiche le cours avec CourseView composable
                        topCourse.value?.let { course ->
                            CourseView(course)
                        }
                    } else if (error.value?.isNotEmpty() == true) {
                        // Affiche le message d'erreur
                        Text(text = error.value ?: "Unknown error")
                    } else {
                        // État de chargement
                        Text(text = "Loading...")
                    }
                }
            }
        }

        // Déclenche la récupération des données via le ViewModel
        courseViewModel.fetchTopCourse()
    }
}