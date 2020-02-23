package com.teamxenox.brogrammer.di.modules

import com.theapache64.twinkill.utils.Font
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FontModule {

    @Singleton
    @Provides
    fun provideKomikax(): Font {
        return Font("fonts/komikax.ttf")
    }
}