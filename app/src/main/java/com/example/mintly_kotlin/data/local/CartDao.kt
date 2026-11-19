package com.example.mintly_kotlin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cartItems")
    fun observeAll(): Flow<List<CartItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CartItemEntity)

    @Query("DELETE FROM cartItems WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM cartItems")
    suspend fun deleteAll()

    @Query("SELECT * FROM cartItems WHERE id = :id")
    suspend fun getById(id: Int): CartItemEntity?
}