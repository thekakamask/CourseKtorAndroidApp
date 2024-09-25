package com.example.ktorapp.repository

import com.example.ktorapp.model.Course
import com.example.ktorapp.network.ApiClient
import com.example.ktorapp.network.RetrofitService
import retrofit2.Response
import javax.inject.Inject

//Gère l'accès aux données provenant de l'API. Il utilise le RetrofitService
// pour faire les appels réseau et retourne la réponse au ViewModel.
//Deux fonctions sont disponibles :
//getTopCourse() : Fait appel à l'API pour récupérer le cours avec le plus haut niveau.
//getCourseById(id: Int) : Fait appel à l'API pour récupérer un cours par son ID.

class CourseRepository @Inject constructor(
    private val retrofitService: RetrofitService
) {
    suspend fun getTopCourse(): Response<Course> {
        return retrofitService.getTopCourse()
    }

    suspend fun getCourseById(id: Int): Response<Course> {
        return retrofitService.getCourseById(id)
    }
}