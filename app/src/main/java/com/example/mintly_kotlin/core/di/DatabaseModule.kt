package com.example.mintly_kotlin.core.di

import android.content.Context
import androidx.room.Room
import com.example.mintly_kotlin.data.local.MintlyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): MintlyDatabase = Room.databaseBuilder<MintlyDatabase>(
            context = context,
            name = "mintly-db"
        ).build()

    @Provides
    fun providesCardDao(db: MintlyDatabase) = db.cardDao()

    @Provides
    fun providesCartDao(db: MintlyDatabase) = db.cartDao()
}