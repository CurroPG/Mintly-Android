package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.data.local.SettingsDatasource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SettingsRepositoryImpl @Inject constructor(
    private val datasource: SettingsDatasource
): SettingsRepository {
    override val darkMode: Flow<Boolean>
        get() = datasource.darkMode
    override val language: Flow<String>
        get() = datasource.language

    override suspend fun setMode(mode: Boolean) {
        datasource.setMode(mode)
    }

    override suspend fun setLanguage(language: String) {
        datasource.setLanguage(language)
    }

}