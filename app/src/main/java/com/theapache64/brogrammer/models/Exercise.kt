package com.theapache64.brogrammer.models

import com.squareup.moshi.Json

data class Exercise(
    @Json(name = "duration")
    val duration: Duration,
    @Json(name = "gif")
    val gif: String, // https://raw.githubusercontent.com/sarthology/brogrammers/master/src/images/tricepdips.gif
    @Json(name = "reps")
    val reps: Reps,
    @Json(name = "title")
    val title: String // Triceps Dips
) {
    data class Reps(
        @Json(name = "easy")
        val easy: Int, // 10
        @Json(name = "hard")
        val hard: Int, // 20
        @Json(name = "medium")
        val medium: Int // 15
    )

    data class Duration(
        @Json(name = "easy")
        val easy: Int, // 0
        @Json(name = "hard")
        val hard: Int, // 0
        @Json(name = "medium")
        val medium: Int // 0
    )
}