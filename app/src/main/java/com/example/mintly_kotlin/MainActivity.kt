package com.example.mintly_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mintly_kotlin.core.navigation.MintlyNavHost
import com.example.mintly_kotlin.core.ui.theme.MintlyKotlinTheme
import com.example.mintly_kotlin.features.settings.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settingsViewModel: SettingsViewModel = hiltViewModel()
            val settings by settingsViewModel.state.collectAsStateWithLifecycle()

            MintlyKotlinTheme(darkTheme = settings.darkMode) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MintlyNavHost()
                }
            }
        }
    }
}
