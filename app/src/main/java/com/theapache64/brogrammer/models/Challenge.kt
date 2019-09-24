package com.theapache64.brogrammer.models

import java.io.Serializable

class Challenge(
    val exercises: List<Exercise>,
    val frequency: Int,
    val workHours: Int,
    val level: Level
) : Serializable {

    enum class Level {
        EASY, MEDIUM, HARD
    }

}