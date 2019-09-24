package com.theapache64.brogrammer.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.theapache64.brogrammer.databinding.ItemExerciseBinding
import com.theapache64.brogrammer.models.Exercise

class ExercisesAdapter(
    context: Context,
    private val exercises: List<Exercise>,
    private val callback: (position: Int) -> Unit
) : RecyclerView.Adapter<ExercisesAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExerciseBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = exercises.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = exercises[position]
        holder.binding.exercise = exercise
    }

    inner class ViewHolder(val binding: ItemExerciseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                callback(layoutPosition)
            }

        }
    }
}