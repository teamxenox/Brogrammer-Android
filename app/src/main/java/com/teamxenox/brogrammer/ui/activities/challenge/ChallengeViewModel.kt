package com.teamxenox.brogrammer.ui.activities.challenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamxenox.brogrammer.data.repositories.ExerciseRepository
import com.teamxenox.brogrammer.models.Exercise
import javax.inject.Inject

class ChallengeViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

    companion object {
        const val MIN_WORK_HOURS = 2
        const val MAX_WORK_HOURS = 12
        const val DEFAULT_FREQUENCY = 2
        const val DEFAULT_WORK_HOURS = MAX_WORK_HOURS * 0.50f
        const val SECTION_COUNT = MAX_WORK_HOURS - MIN_WORK_HOURS
    }


    private val exercises = MutableLiveData<List<Exercise>>()
    fun getExercises(): LiveData<List<Exercise>> = exercises

    init {
        this.exercises.value = exerciseRepository.exercises
    }
}