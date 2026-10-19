package com.example.mintly_kotlin.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route{
    @Serializable
    object Shop: Route

    @Serializable
    object Register: Route

    @Serializable
    object Home: Route

    @Serializable
    object CardCollection: Route

    @Serializable
    object Game: Route
}

