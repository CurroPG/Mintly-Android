package com.example.mintly_kotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CardEntity::class, CartItemEntity::class], version = 1, exportSchema = false)
abstract class MintlyDatabase: RoomDatabase(){
    abstract fun cardDao(): CardDao
    abstract fun cartDao(): CartDao
}
