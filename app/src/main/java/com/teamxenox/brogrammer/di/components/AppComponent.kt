package com.teamxenox.brogrammer.di.components

import com.teamxenox.brogrammer.App
import com.teamxenox.brogrammer.di.modules.AppModule
import com.theapache64.twinkill.di.modules.ContextModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    // inject the above given modules into this App class
    fun inject(app: App)
}