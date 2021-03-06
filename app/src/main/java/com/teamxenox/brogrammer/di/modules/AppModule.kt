package com.teamxenox.brogrammer.di.modules

import android.app.Application
import com.theapache64.twinkill.di.modules.ContextModule

import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        FontModule::class,
        ContextModule::class,
        MoshiModule::class,
        ViewModelModule::class,
        ActivitiesBuilderModule::class
    ]
)
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application {
        return this.application
    }

}