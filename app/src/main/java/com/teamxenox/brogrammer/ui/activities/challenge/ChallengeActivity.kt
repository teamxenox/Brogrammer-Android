package com.teamxenox.brogrammer.ui.activities.challenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.teamxenox.brogrammer.R
import com.teamxenox.brogrammer.databinding.ActivityChallengeBinding
import com.teamxenox.brogrammer.ui.adapters.ExercisesAdapter
import com.theapache64.twinkill.logger.info
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import com.xw.repo.BubbleSeekBar
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

        // Setting work hour values
        binding.bsbWorkHrs.configBuilder
            .min(ChallengeViewModel.MIN_WORK_HOURS.toFloat())
            .progress(ChallengeViewModel.DEFAULT_WORK_HOURS)
            .max(ChallengeViewModel.MAX_WORK_HOURS.toFloat())
            .sectionCount(ChallengeViewModel.SECTION_COUNT)
            .build()

        binding.bsbFrequency.configBuilder
            .progress(ChallengeViewModel.DEFAULT_FREQUENCY.toFloat())
            .build()

        setFrequency(ChallengeViewModel.DEFAULT_WORK_HOURS.toInt())


        binding.bsbWorkHrs.onProgressChangedListener =
            object : BubbleSeekBar.OnProgressChangedListener {
                override fun onProgressChanged(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    info("Progress changed to $progress")
                }

                override fun getProgressOnActionUp(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float
                ) {
                    info("Progress up : $progress")
                }

                override fun getProgressOnFinally(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    info("Progress finally $progress")
                    setFrequency(progress)
                }

            }

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

    private fun setFrequency(totalHoursOfWork: Int) {
        binding.bsbFrequency.configBuilder
            .max(totalHoursOfWork.toFloat())
            .sectionCount(totalHoursOfWork - 1)
            .build()

        YoYo.with(Techniques.Pulse)
            .duration(500)
            .playOn(binding.bsbFrequency)
    }

    override fun onGoBackClicked() {
        finish()
    }

    override fun onStartSessionClicked() {

    }
}
