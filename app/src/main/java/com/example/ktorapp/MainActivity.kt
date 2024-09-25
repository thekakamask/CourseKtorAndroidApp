package com.example.ktorapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.ktorapp.ui.theme.KtorAppTheme
import com.example.ktorapp.viewmodel.CourseViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.livedata.observeAsState
import com.example.ktorapp.ui.CourseView


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val courseViewModel: CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorAppTheme {
                // UI Logic here, observing ViewModel data
                val welcomeMessage= courseViewModel.welcomeMessage.observeAsState()
                val topCourse = courseViewModel.topCourse.observeAsState()
                val error = courseViewModel.error.observeAsState()

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column {
                        //display welcome message
                        Text(text= welcomeMessage.value?: "Loading...")
                        //Button for going to top course
                        Button(onClick= {
                            courseViewModel.fetchTopCourse()
                        }) {
                            Text("See Top Course")
                        }
                        //button for going to Course ID choice screen
                        Button(onClick = {
                            //Launch a new activity for choose the ID of course
                            startActivity(Intent(this@MainActivity, CourseByIdActivity::class.java))
                        }) {
                            Text("Choose a course by ID ")
                        }
                        // Display results of the top course
                        topCourse.value?.let{ course ->
                            CourseView(course)
                        }
                        //Display errors if their are
                        error.value?.let { errorMessage ->
                            Text(text= errorMessage)
                        }
                    }
                }
            }
        }

        // Triggers data recovery via ViewModel
        courseViewModel.fetchWelcomeMessage()
    }
}

//The MainActivity class is an Android activity that serves as the main entry point
//for the Android application. It uses Jetpack Compose for the user interface and
//is integrated with Hilt for dependency injection.

//Dependency injection with Hilt: Thanks to the @AndroidEntryPoint annotation, the
//activity can automatically inject dependencies, including the CourseViewModel,
//which is used to manage the logic of API calls and data.

//Reactive UI with Jetpack Compose: The class uses Jetpack Compose to define the
//user interface. The interface is built dynamically according to the data
//provided by the ViewModel:
//-welcomeMessage: A welcome message retrieved via a request to the server.
//-topCourse: The data for the course with the highest level.
//-error: Potential errors are displayed if a request fails.

//User interaction :
//-Display welcome message: When the application is launched, the welcome message
//is displayed.
//-Button to view the course with the highest level: The user can click on this
//-button to send a request via the ViewModel and display the highest course
//retrieved by the API.
//-Button to select a course by ID: Another button allows the user to navigate
//to a new activity (CourseByIdActivity), where he can enter the ID of a specific
//course and view its details.

//Error handling and data display:
//-If an error occurs during API calls (such as course retrieval), an error message
//is displayed.
//-Course or welcome message data are automatically displayed when available,
//thanks to the use of LiveData and observers via observeAsState.

//API calls triggered on opening:
//As soon as the activity is created, the ViewModel's fetchWelcomeMessage()
//method is called to retrieve the welcome message from the server.