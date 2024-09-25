package com.example.ktorapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorapp.model.Course
import com.example.ktorapp.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val repository: CourseRepository
) : ViewModel() {

    private val _welcomeMessage = MutableLiveData<String>()
    val welcomeMessage: LiveData<String> = _welcomeMessage

    private val _topCourse = MutableLiveData<Course>()
    val topCourse: LiveData<Course?> = _topCourse

    private val _selectedCourse = MutableLiveData<Course>()
    val selectedCourse:LiveData<Course?> = _selectedCourse

    private val _error = MutableLiveData<String>()
    val error: LiveData<String?> = _error

    fun fetchWelcomeMessage() {
        viewModelScope.launch{
            val response = repository.getWelcomeMessage()
            if(response.isSuccessful) {
                _welcomeMessage.postValue(response.body())
            } else {
                _error.postValue("Error fetching welcome message")
            }
        }
    }

    fun fetchTopCourse() {
        viewModelScope.launch {
            val response = repository.getTopCourse()
            if (response.isSuccessful) {
                _topCourse.postValue(response.body())
            } else {
                _error.postValue("Error fetching top course")
            }
        }
    }

    fun fetchCourseById(id: Int) {
        viewModelScope.launch {
            val response = repository.getCourseById(id)
            if (response.isSuccessful && response.body() != null) {
                _selectedCourse.postValue(response.body())
            } else {
                _error.postValue("Error fetching course with ID: $id")
            }
        }
    }
}

//The CourseViewModel class is a ViewModel that manages the data logic for the user
//interface in the Android application. It uses Hilt for dependency injection and
//interacts with a repository to retrieve data.

//Here are the main features of the class:

//LiveData attributes :
//_welcomeMessage: Stores the welcome message retrieved from the API, accessible
//via welcomeMessage so that the UI can observe changes.
//_topCourse : Contains the course with the highest level (top course), retrieved
//from the API and accessible via topCourse.
//_selectedCourse: Contains a course selected by ID, retrieved via the API.
//_error: Stores error messages in case of problems during data retrieval,
//accessible via error.

//Main methods :
//-fetchWelcomeMessage(): Fetches the welcome message using the repository, and
//updates _welcomeMessage if the request is successful or _error if it fails.
//-fetchTopCourse(): Retrieves the highest course and updates _topCourse or _error
//depending on the response.
//-fetchCourseById(id: Int) : Retrieves a specific course by its ID and updates
// _selectedCourse or _error.

//The class thus manages interactions with the repository and exposes data to the
//UI via LiveData objects, enabling the UI to react reactively to data changes.