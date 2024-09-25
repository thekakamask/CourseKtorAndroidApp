package com.example.ktorapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorapp.model.Course
import com.example.ktorapp.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Responsable de la gestion des données entre l'UI et le repository. Il utilise
// des LiveData pour exposer les données (topCourse et error) de manière réactive,
// afin que l'UI se mette à jour automatiquement lorsque les données changent.
//Il contient deux méthodes principales :
//fetchTopCourse() : Récupère le cours le plus élevé en appelant la fonction
// correspondante dans le repository.
//fetchCourseById(id: Int) : Récupère un cours spécifique selon son ID, via le
// repository.

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val repository: CourseRepository
) : ViewModel() {

    private val _topCourse = MutableLiveData<Course>()
    val topCourse: LiveData<Course> = _topCourse

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchTopCourse() {
        viewModelScope.launch {
            val response = repository.getTopCourse()
            if (response.isSuccessful) {
                _topCourse.postValue(response.body())
            } else {
                _error.postValue("Error fetching top course")
            }
        }
    }

    fun fetchCourseById(id: Int) {
        viewModelScope.launch {
            val response = repository.getCourseById(id)
            if (response.isSuccessful) {
                _topCourse.postValue(response.body()) // You can also use separate LiveData for specific course
            } else {
                _error.postValue("Error fetching course with ID: $id")
            }
        }
    }
}