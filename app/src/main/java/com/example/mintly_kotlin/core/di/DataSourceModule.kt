package com.example.mintly_kotlin.core.di

import com.example.mintly_kotlin.data.local.CartLocalDatasource
import com.example.mintly_kotlin.data.local.CartRoomDatasource
import com.example.mintly_kotlin.data.local.CatalogLocalDatasource
import com.example.mintly_kotlin.data.local.CatalogRoomDatasource
import com.example.mintly_kotlin.data.remote.CatalogRemoteDatasource
import com.example.mintly_kotlin.data.remote.CatalogRetrofitDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindCatalogRemoteDatasource(
        impl: CatalogRetrofitDatasource
    ): CatalogRemoteDatasource

    @Binds
    @Singleton
    abstract fun bindCatalogLocalDatasource(
        impl: CatalogRoomDatasource
    ): CatalogLocalDatasource

    @Binds
    @Singleton
    abstract fun bindCartLocalDatasource(
        impl: CartRoomDatasource
    ): CartLocalDatasource
}