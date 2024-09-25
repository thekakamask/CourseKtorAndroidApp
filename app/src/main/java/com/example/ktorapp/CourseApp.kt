package com.example.ktorapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Classe d'application qui active Hilt. Elle est annotée avec @HiltAndroidApp,
// ce qui déclenche le processus d'injection de dépendances dans toute l'application.

@HiltAndroidApp
class CourseApp : Application()