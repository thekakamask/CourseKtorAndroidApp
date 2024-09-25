package com.example.ktorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.ktorapp.ui.CourseView
import com.example.ktorapp.ui.theme.KtorAppTheme
import com.example.ktorapp.viewmodel.CourseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseByIdActivity : ComponentActivity() {

    private val courseViewModel: CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorAppTheme {
                //UI Logic here
                val selectedCourse = courseViewModel.selectedCourse.observeAsState()
                val error = courseViewModel.error.observeAsState()
                var courseId by remember {mutableStateOf("")}

                Column {
                    // Space for enter ID
                    TextField(
                        value= courseId,
                        onValueChange= { courseId= it },
                        label= {Text("Enter Course Id")}
                    )

                    Button(onClick= {
                        courseViewModel.fetchCourseById(courseId.toInt())
                    }) {
                        Text("see the course")
                    }
                    // Display course if found
                    selectedCourse.value?.let { course ->
                        CourseView(course)
                    } ?: Text(text = "No course found")  // Add fallback for check if course is null

                    // Display errors
                    error.value?.let { errorMessage ->
                        Text(text = errorMessage)
                    } ?: Text(text = "No errors")  // Indicate if errors don't exist

                }
            }
        }
    }

}
//The CourseByIdActivity class is an Android activity that uses Jetpack Compose to
//manage the user interface.

//Dependency injection with Hilt: Thanks to the @AndroidEntryPoint annotation,
//this activity is able to inject dependencies, in particular an instance of
//CourseViewModel, which is used to manage business logic and network calls.

//Reactive UI with Jetpack Compose: The activity uses Jetpack Compose to build the
//user interface. It displays a column (Column) containing a text field (TextField)
//for entering a course ID and a button (Button) for retrieving course details.

//ViewModel data observation : The ViewModel exposes two observable objects:
//selectedCourse and error, both encapsulated in LiveData objects.
//-selectedCourse: When a course is successfully retrieved (via the fetchCourseById
//method), the information is displayed using the CourseView composable.
//-error: If an error occurs (for example, a course with the given ID is not found),
// an error message is displayed.

//User interaction:
//The user enters a course ID in the text field. By clicking on the “See the course”
//button, the ID is sent to the ViewModel, which triggers the API call to retrieve
//the details of the corresponding course. If the course is found, it is displayed;
//if not, an error message is displayed.