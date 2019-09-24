package com.theapache64.brogrammer.ui.activities.trainer

import androidx.lifecycle.ViewModel
import com.theapache64.brogrammer.data.repositories.ExerciseRepository
import javax.inject.Inject

class TrainerViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

}