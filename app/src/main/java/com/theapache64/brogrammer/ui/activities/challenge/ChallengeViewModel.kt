package com.theapache64.brogrammer.ui.activities.challenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theapache64.brogrammer.data.repositories.ExerciseRepository
import com.theapache64.brogrammer.models.Exercise
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {
    private val exercises = MutableLiveData<List<Exercise>>()
    fun getExercises(): LiveData<List<Exercise>> = exercises

    init {
        this.exercises.value = exerciseRepository.exercises
    }
}