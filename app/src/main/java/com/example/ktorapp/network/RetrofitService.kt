package com.example.ktorapp.network

import com.example.ktorapp.model.Course
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("/")
    suspend fun getWelcomeMessage(): Response<String>

    @GET("/course/top")
    suspend fun getTopCourse(): Response<Course>

    @GET("/course/{id}")
    suspend fun getCourseById(@Path("id") id: Int): Response<Course>
}

//The RetrofitService interface defines the network calls your application will make
//to the server via Retrofit. Here's a summary of what it does:

//-getWelcomeMessage:
//Sends a GET request to the endpoint / to retrieve a welcome message in string form.
//This method is suspended and returns a response (Response<String>), which means
//it can be called inside a coroutine.

//-getTopCourse:
//Sends a GET request to the /course/top endpoint to retrieve the course with the
//highest level.
//It returns an object of type Response<Course>, where Course is the course data
//model.

//-getCourseById:
//Sends a GET request to the /course/{id} endpoint, where {id} is a URL parameter
//used to specify the ID of a course. Returns a response (Response<Course>) with the
//course information corresponding to the given ID.

//These methods are suspended, which means they run asynchronously in coroutines
//to avoid blocking the main thread during network calls.