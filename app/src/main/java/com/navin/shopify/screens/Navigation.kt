package com.navin.shopify.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.navin.shopify.screens.about.AboutScreen
import com.navin.shopify.screens.dashboard.DashboardScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {

        composable(route = "dashboard") {
            DashboardScreen(navController)
        }
        composable(route = "about") {
            AboutScreen(navController)
        }

    }

}