package com.example.jetpackcomposepractice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposepractice.ui.screens.detail.DetailScreen
import com.example.jetpackcomposepractice.ui.screens.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(route = NavItem.Main.route) {
            MainScreen { MediaItem ->
                navController.navigate(NavItem.Detail.createNavRoute(MediaItem.id))
            }
        }
        composable(
            route = NavItem.Detail.route,
            arguments = NavItem.Detail.args
        ) { backStackEntry ->
            val mediaId = backStackEntry.arguments?.getInt(NavArg.MediaId.key)
            requireNotNull(mediaId) {
                "Not able to be null since the screen requires " +
                        "this argument in the URL to be reached"
            }
            DetailScreen(
                mediaId = mediaId,
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}