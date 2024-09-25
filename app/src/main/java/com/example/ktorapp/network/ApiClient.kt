package com.example.ktorapp.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiClient {
    private const val BASE_URL = "http://10.0.2.2:8080" // Alias for localhost from emulator

    // Configure GSON
    private val gson = GsonBuilder()
        .setLenient() // Allows more tolerant JSON responses
        .create()

    // Add logs interceptor for see HTTP requests and responses
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Allows to see requests and responses details
    }

    // Create OkHttp client with interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Create Retrofit instance with client and GSON converter
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client) // Use client with activate logging
        .addConverterFactory(ScalarsConverterFactory.create()) // for text responses
        .addConverterFactory(GsonConverterFactory.create(gson)) // for JSON responses
        .build()


    // RetrofitService instance for API calls
    val retrofitService: RetrofitService = retrofit.create(RetrofitService::class.java)
}

//The ApiClient class is a singleton object that configures and manages network calls
//for the Android application. Here is a summary of how it works:

//-BASE_URL:
//Defines the base URL for network calls: http://10.0.2.2:8080. This address
//corresponds to the localhost alias from the Android emulator to connect to a local
//server on the host machine.

//-Gson Configuration:
//Uses GsonBuilder with the setLenient() option to handle the serialization and
//deserialization of JSON objects in a more tolerant way, allowing better handling
//of malformed or unexpected JSON responses.

//-Retrofit Configuration:
//Configures a Retrofit object by specifying the base URL and adding a
//GsonConverterFactory converter to transform JSON responses into Kotlin objects
//via Gson.

//-RetrofitService:
//Exposes an instance of the RetrofitService service that contains the network call
//methods (defined in the RetrofitService interface). This allows other parts of the
//application (such as the CourseRepository) to use this service to make API calls.

//This configuration centralizes the management of network calls and ensures that
//all calls are made to the same base URL with the same serialization parameters.