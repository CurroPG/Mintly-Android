package com.example.mintly_kotlin.core.di

import com.example.mintly_kotlin.data.CardLocalRepository
import com.example.mintly_kotlin.data.CardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMintlyRepository(
        impl: CardLocalRepository
    ): CardRepository
}