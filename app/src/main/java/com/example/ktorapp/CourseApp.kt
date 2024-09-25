package com.example.ktorapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CourseApp : Application()

//The CourseApp class annotated with @HiltAndroidApp extends Android's Application
//class and is used to configure Hilt, the dependency injection framework.

// Its main roles are as follows:
//-Entry point for Hilt: Using the @HiltAndroidApp annotation, this class initializes
//Hilt for the entire application, enabling Hilt to inject dependencies into all
//other classes in the application (activities, fragments, ViewModel, etc.).
//-Application lifecycle: The CourseApp class can also be used to manage the overall
//application lifecycle, if required, but in this case, its sole role is to configure
//Hilt.

//In short, CourseApp is the main class used to initialize Hilt for the entire
//application, and to enable dependencies to be injected into the various classes
//of the Android application.