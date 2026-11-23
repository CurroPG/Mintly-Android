package com.example.mintly_kotlin.data

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val darkMode: Flow<Boolean>
    val language: Flow<String>
    suspend fun setMode(mode: Boolean)
    suspend fun setLanguage(language: String)
}