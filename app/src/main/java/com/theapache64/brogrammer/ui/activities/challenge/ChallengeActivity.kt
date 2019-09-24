package com.theapache64.brogrammer.ui.activities.challenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theapache64.brogrammer.R
import com.theapache64.brogrammer.databinding.ActivityChallengeBinding
import com.theapache64.brogrammer.ui.adapters.ExercisesAdapter
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import dagger.android.AndroidInjection
import javax.inject.Inject

class ChallengeActivity : BaseAppCompatActivity(), ChallengeHandler {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ChallengeActivity::class.java).apply {
                // data goes here
            }
        }
    }


    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: ActivityChallengeBinding
    private lateinit var viewModel: ChallengeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = bindContentView(R.layout.activity_challenge)

        viewModel = ViewModelProviders.of(this, factory).get(ChallengeViewModel::class.java)

        binding.handler = this
        binding.viewModel = viewModel

        binding.rvExercises.apply {
            layoutManager =
                LinearLayoutManager(this@ChallengeActivity, LinearLayoutManager.HORIZONTAL, false)
            itemAnimator = null
        }

        // Watching for data
        viewModel.getExercises().observe(this, Observer { exercises ->

            val adapter = ExercisesAdapter(this, exercises) { position ->
                // Exercise clicked
                val exr = exercises[position]
                exr.isSelected = !exr.isSelected
                binding.rvExercises.adapter!!.notifyItemChanged(position)
            }

            binding.rvExercises.adapter = adapter
        })
    }

    override fun onGoBackClicked() {
        finish()
    }
}
