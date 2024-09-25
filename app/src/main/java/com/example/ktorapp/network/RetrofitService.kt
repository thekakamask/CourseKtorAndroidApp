package com.example.ktorapp.network

import com.example.ktorapp.model.Course
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//Interface Retrofit qui définit les appels réseau disponibles pour ton application.
// Elle contient deux fonctions :
//getTopCourse() : Appel pour récupérer le cours avec le plus haut niveau.
//getCourseById(id: Int) : Appel pour récupérer un cours spécifique par son ID.

interface RetrofitService {
    @GET("/course/top")
    suspend fun getTopCourse(): Response<Course>

    @GET("/course/{id}")
    suspend fun getCourseById(@Path("id") id: Int): Response<Course>
}