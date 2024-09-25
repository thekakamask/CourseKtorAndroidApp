package com.example.ktorapp.model

import com.google.gson.annotations.SerializedName

//Représente le modèle de données pour les cours, qui correspond au modèle envoyé
// par le serveur Ktor.
//Utilise l'annotation @SerializedName pour mapper les champs JSON renvoyés par
// l'API à leurs équivalents dans la classe Kotlin. Cela permet de gérer la
// désérialisation correcte des données JSON en objets Kotlin.
//Chaque instance de cette classe stocke les informations sur un cours
// (ID, titre, niveau, etc.).

data class Course(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("lvl") val lvl: Int,
    @SerializedName("isActive") val isActive: Boolean
)
