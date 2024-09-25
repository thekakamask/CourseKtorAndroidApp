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

//The AppModule class is a Dagger Hilt module that configures dependency injections
//in the Android application. Here's a summary of its features:

//-@Module and @InstallIn annotation:
//Indicates that this class is a Dagger Hilt module, which means it is used to
//provide dependencies to the application. The @InstallIn(SingletonComponent::class)
//annotation specifies that these dependencies will be available throughout the
//application's lifecycle, i.e. as long as it is running.

//-provideRepository :
//Method that provides an instance of CourseRepository. It takes a RetrofitService
//as parameter and returns a CourseRepository object by injecting it with this
//service. This allows Hilt to automatically inject this dependency whenever a
//CourseRepository is required.

//-provideRetrofitService:
//Method that returns an instance of RetrofitService by retrieving the service
//configured in ApiClient. This method centralizes the use of RetrofitService
//throughout the application.

//In short, this module simplifies dependency management by using Dagger Hilt to
//automatically inject instances of CourseRepository and RetrofitService into
//components that need them, without having to instantiate them manually.