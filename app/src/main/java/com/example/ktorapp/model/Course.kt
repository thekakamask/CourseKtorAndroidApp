package com.example.ktorapp.model

import com.google.gson.annotations.SerializedName


data class Course(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("lvl") val lvl: Int,
    @SerializedName("isActive") val isActive: Boolean
)

//The Course class is a Kotlin data class that represents a data model for a course.

//Here's what it does:
//Attributes :
//-id: a unique identifier for the course (of type Int).
//-title: the course title (of type String).
//-lvl: the course level (of type Int).
//-isActive: a Boolean indicating whether the course is active or not.

//Serialization with Gson :
//Each attribute is annotated with @SerializedName, which indicates the exact name
//these properties will have in the JSON during network exchanges. For example, the
//title attribute will be linked to the key “title” in JSON.

//This class is used to model course data retrieved from or sent to the API.
//The @SerializedName annotations facilitate conversion between the Kotlin object
//and the JSON format for network calls.
