package com.theapache64.brogrammer.data.repositories

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.theapache64.brogrammer.models.Exercise
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExerciseRepository @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) {

    val exercises by lazy {
        val jsonString = context.assets.open("json/exercises.json").bufferedReader().readText()
        val moshiType = Types.newParameterizedType(List::class.java, Exercise::class.java)
        val adapter = moshi.adapter<List<Exercise>>(moshiType)
        adapter.fromJson(jsonString)!!
    }

}