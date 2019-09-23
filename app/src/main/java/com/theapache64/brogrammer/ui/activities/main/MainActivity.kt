package com.theapache64.brogrammer.ui.activities.main


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.theapache64.brogrammer.R
import com.theapache64.brogrammer.databinding.ActivityMainBinding
import com.theapache64.brogrammer.ui.activities.trainer.TrainerActivity
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseAppCompatActivity(), MainHandler {

    companion object {
        const val ID = R.id.MAIN_ACTIVITY_ID

        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = bindContentView<ActivityMainBinding>(R.layout.activity_main)
        this.viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.handler = this

        binding.ivGymBoy.apply {
            post {
                /**
                 * Animating gym boy
                 */
                YoYo.with(Techniques.Tada)
                    .duration(1500)
                    .repeat(YoYo.INFINITE)
                    .interpolate(AccelerateDecelerateInterpolator())
                    .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                    .playOn(this)
            }
        }

        onRandomClgClicked()
    }

    override fun onRandomClgClicked() {
        startActivity(TrainerActivity.getStartIntent(this))
    }

    override fun onCreateClgClicked() {

    }

    override fun onSignClicked() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://teamxenox.com/")
            )
        )
    }


}
