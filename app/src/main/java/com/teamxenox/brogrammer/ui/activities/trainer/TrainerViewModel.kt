package com.teamxenox.brogrammer.ui.activities.trainer

import androidx.lifecycle.ViewModel
import com.teamxenox.brogrammer.data.repositories.ExerciseRepository
import javax.inject.Inject

class TrainerViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

}