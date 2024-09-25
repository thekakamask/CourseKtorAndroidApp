package com.example.ktorapp.di

import com.example.ktorapp.network.ApiClient
import com.example.ktorapp.network.RetrofitService
import com.example.ktorapp.repository.CourseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

//AppModule est un module Dagger Hilt qui gère l'injection de dépendances.
// Il fournit des instances de CourseRepository et de RetrofitService pour être
// utilisées dans l'application.
//Grâce à Hilt, tu n'as pas besoin de créer manuellement ces objets. Hilt les
// injecte automatiquement là où ils sont nécessaires, par exemple dans le
// ViewModel ou dans les activités.

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(retrofitService: RetrofitService): CourseRepository {
        return CourseRepository(retrofitService)
    }

    @Provides
    @Singleton
    fun provideRetrofitService(): RetrofitService {
        return ApiClient.retrofitService
    }
}