package com.example.mintly_kotlin.data.local

import androidx.datastore.core.DataStore
import javax.inject.Inject
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
): SettingsDatasource {
    private val uiMode = booleanPreferencesKey("ui_mode")
    private val languageKey = stringPreferencesKey("language")

    override val darkMode: Flow<Boolean>
        get() = dataStore.data.map { preferences ->
            preferences[uiMode] ?: false
        }

    override val language: Flow<String>
        get() = dataStore.data.map { preferences ->
            preferences[languageKey]?: "es"
        }

    override suspend fun setMode(mode: Boolean){
        dataStore.updateData { preferences ->
            preferences.toMutablePreferences().also { it[uiMode] = mode } }
    }

    override suspend fun setLanguage(language: String) {
        dataStore.updateData { preferences ->
            preferences.toMutablePreferences().also { it[languageKey] = language }
        }
    }
}