package com.teamxenox.brogrammer.di.modules
import com.teamxenox.brogrammer.ui.activities.challenge.ChallengeActivity
import com.teamxenox.brogrammer.ui.activities.trainer.TrainerActivity


import com.teamxenox.brogrammer.ui.activities.main.MainActivity

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

@ContributesAndroidInjector
abstract fun getChallengeActivity(): ChallengeActivity

}