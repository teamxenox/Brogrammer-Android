package com.theapache64.brogrammer.di.components

import com.theapache64.brogrammer.App
import com.theapache64.brogrammer.di.modules.AppModule
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