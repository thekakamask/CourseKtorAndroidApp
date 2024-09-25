package com.example.ktorapp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton qui configure et expose un client Retrofit prêt à effectuer des appels
// réseau à l'API Ktor.
//Il est configuré avec une base URL et un convertisseur Gson pour la désérialisation
// des réponses JSON en objets Kotlin.
//retrofitService est l'instance de l'interface RetrofitService, et elle est utilisée
// dans toute l'application pour faire des appels réseau.

object ApiClient {
    private const val BASE_URL = "http://10.0.2.2:8080" // Alias pour localhost depuis l'émulateur

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)
}