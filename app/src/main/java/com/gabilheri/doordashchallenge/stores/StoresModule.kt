package com.gabilheri.doordashchallenge.stores

import com.gabilheri.doordashchallenge.stores.data.StoreItemFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class StoresModule {

    @Provides
    @Singleton
    fun storeItemFactory(): StoreItemFactory {
        return StoreItemFactory()
    }
}