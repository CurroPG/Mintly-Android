package com.example.mintly_kotlin.core.di

import com.example.mintly_kotlin.data.CardLocalRepository
import com.example.mintly_kotlin.data.CardRepository
import com.example.mintly_kotlin.data.CartLocalRepository
import com.example.mintly_kotlin.data.CartRepository
import com.example.mintly_kotlin.data.CatalogRepository
import com.example.mintly_kotlin.data.CatalogRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMintlyRepository(
        impl: CardLocalRepository
    ): CardRepository

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

}
