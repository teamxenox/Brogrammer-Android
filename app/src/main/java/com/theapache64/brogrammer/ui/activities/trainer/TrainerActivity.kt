package com.theapache64.brogrammer.ui.activities.trainer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.theapache64.brogrammer.R
import com.theapache64.brogrammer.databinding.ActivityTrainerBinding
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import dagger.android.AndroidInjection
import javax.inject.Inject

class TrainerActivity : BaseAppCompatActivity(), TrainerHandler {

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, TrainerActivity::class.java).apply {
                // data goes here
            }
        }
    }


    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: ActivityTrainerBinding
    private lateinit var viewModel: TrainerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = bindContentView(R.layout.activity_trainer)

        viewModel = ViewModelProviders.of(this, factory).get(TrainerViewModel::class.java)

        binding.handler = this
        binding.viewModel = viewModel
    }
}
