package com.example.ktorapp.repository

import com.example.ktorapp.model.Course
import com.example.ktorapp.network.RetrofitService
import retrofit2.Response
import javax.inject.Inject

class CourseRepository @Inject constructor(
    private val retrofitService: RetrofitService
) {
    suspend fun getWelcomeMessage(): Response<String> {
        return retrofitService.getWelcomeMessage()
    }


    suspend fun getTopCourse(): Response<Course> {
        return retrofitService.getTopCourse()
    }

    suspend fun getCourseById(id: Int): Response<Course> {
        return retrofitService.getCourseById(id)
    }
}

//The CourseRepository class handles network calls using an injected instance of
//RetrofitService to retrieve data from a server. It contains three main functions,
//each making an asynchronous network call using Retrofit:

//-getWelcomeMessage():
//Makes an API call to retrieve a welcome message in string form.
//Returns a Response<String> object containing the server response.
//-getTopCourse():
//Retrieves information on the top course (the course with the highest level).
//Returns a Response<Course> object containing course details.
//-getCourseById(id: Int) :
//Makes a query to obtain details of a specific course, identified by its id.
//Returns a Response<Course> object containing the corresponding course information.

//The class uses dependency injection via Hilt (@Inject constructor) to obtain the
//RetrofitService instance, which separates the network logic from the user
//interface and facilitates testing and maintenance.