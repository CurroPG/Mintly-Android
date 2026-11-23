package com.example.mintly_kotlin.data.local

import kotlinx.coroutines.flow.Flow

interface SettingsDatasource {
    val darkMode: Flow<Boolean>
    val language: Flow<String>
    suspend fun setMode(mode: Boolean)
    suspend fun setLanguage(language: String)
}