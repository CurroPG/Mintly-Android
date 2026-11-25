package com.example.mintly_kotlin.core.di

import com.example.mintly_kotlin.data.CartLocalRepository
import com.example.mintly_kotlin.data.CartRepository
import com.example.mintly_kotlin.data.CatalogRepository
import com.example.mintly_kotlin.data.CatalogRepositoryImpl
import com.example.mintly_kotlin.data.SettingsRepository
import com.example.mintly_kotlin.data.SettingsRepositoryImpl
import com.example.mintly_kotlin.data.local.SettingsDataStore
import com.example.mintly_kotlin.data.local.SettingsDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCartRepository(
        impl: CartLocalRepository
    ): CartRepository

    @Binds
    @Singleton
    abstract fun bindCatalogRepository(
        impl: CatalogRepositoryImpl
    ): CatalogRepository

    @Binds
    @Singleton
    abstract fun bindSettingsRepository(
        impl: SettingsRepositoryImpl
    ): SettingsRepository

    @Binds
    @Singleton
    abstract fun bindSettingsDataSource(
        impl: SettingsDataStore
    ): SettingsDatasource

}
