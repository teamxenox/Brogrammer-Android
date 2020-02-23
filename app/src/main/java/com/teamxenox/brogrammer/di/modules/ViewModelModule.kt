package com.teamxenox.brogrammer.di.modules
import com.teamxenox.brogrammer.ui.activities.challenge.ChallengeViewModel
import com.teamxenox.brogrammer.ui.activities.trainer.TrainerViewModel

import androidx.lifecycle.ViewModel
import com.teamxenox.brogrammer.ui.activities.main.MainViewModel
import com.theapache64.twinkill.di.modules.BaseViewModelModule
import com.theapache64.twinkill.utils.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [BaseViewModelModule::class])
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
@Binds
@IntoMap
@ViewModelKey(TrainerViewModel::class)
abstract fun bindTrainerViewModel(viewModel: TrainerViewModel): ViewModel

@Binds
@IntoMap
@ViewModelKey(ChallengeViewModel::class)
abstract fun bindChallengeViewModel(viewModel: ChallengeViewModel): ViewModel

}