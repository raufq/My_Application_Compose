package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


import androidx.navigation.compose.rememberNavController
import com.aqube.compose.ProfileDetailsScreen
import com.aqube.compose.ProfileListScreen
import com.aqube.compose.userList


const val USER_ID_KEY = "userId"

@Composable
fun UsersApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(route = "HomeScreen") {
            homeScreen(navController)
        }
        composable(route = "userList") {
            ProfileListScreen(userList, navController)
        }
        composable(route = "productList") {
            //ProfileListScreen(userList, navController)
            productList(navController)
        }
        composable(
            route = "userDetails/{$USER_ID_KEY}",
            arguments = listOf(navArgument(USER_ID_KEY) {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            ProfileDetailsScreen(
                navBackStackEntry.arguments!!.getInt(USER_ID_KEY), navController
            )
        }
    }
}
