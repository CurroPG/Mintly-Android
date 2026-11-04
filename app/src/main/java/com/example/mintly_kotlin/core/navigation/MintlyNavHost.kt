package com.example.mintly_kotlin.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mintly_kotlin.features.cart.CartScreen
import com.example.mintly_kotlin.features.collection.CollectionScreen
import com.example.mintly_kotlin.features.game.GameScreen
import com.example.mintly_kotlin.features.home.HomeScreen
import com.example.mintly_kotlin.features.register.RegisterScreen
import com.example.mintly_kotlin.features.shop.ShopScreen

@Composable
fun MintlyNavHost(controller: NavHostController = rememberNavController()) {
    NavHost(navController = controller, startDestination = Route.Home) {
        composable<Route.Home> {
            HomeScreen(
                toCardCollection = { controller.navigate(Route.CardCollection) },
                toShop = { controller.navigate(Route.Shop) },
                toCart = { controller.navigate(Route.Cart) },
                toRegister = { controller.navigate(Route.Register) },
                toGame = { controller.navigate(Route.Game) }
            )
        }
        composable<Route.CardCollection> {
            CollectionScreen(toHome = { controller.popBackStack() })
        }
        composable<Route.Shop> {
            ShopScreen(
                toHome = { controller.popBackStack() },
                toCart = { controller.navigate(Route.Cart) },
                toGame = { controller.navigate(Route.Game) }
            )
        }
        composable<Route.Cart> {
            CartScreen(toHome = { controller.popBackStack() })
        }
        composable<Route.Register> {
            RegisterScreen(toHome = { controller.popBackStack() })
        }
        composable<Route.Game> {
            GameScreen(toHome = { controller.popBackStack() })
        }
    }
}