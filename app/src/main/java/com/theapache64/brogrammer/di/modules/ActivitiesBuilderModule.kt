package com.theapache64.brogrammer.di.modules
import com.theapache64.brogrammer.ui.activities.trainer.TrainerActivity


import com.theapache64.brogrammer.ui.activities.main.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * To hold activities to support AndroidInjection call from dagger.
 */
@Module
abstract class ActivitiesBuilderModule {


    @ContributesAndroidInjector
    abstract fun getMainActivity(): MainActivity
@ContributesAndroidInjector
abstract fun getTrainerActivity(): TrainerActivity

}