package com.example.learncompose.Navigations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Navigation()
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Second.route +"/{name}/{age}",/*3- route url to pass data ?name={name}*/
            /*1- navArgument*/
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "Huda"
                    nullable = true
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                    defaultValue = 1
                    nullable = false
                }
            )) { navBackStackEntry ->
            /*2- navBackStackEntry*/
            val name = navBackStackEntry.arguments?.getString("name")
            val age = navBackStackEntry.arguments?.getInt("age")


            SecondScreen(navController = navController,name,age)

        }

        composable(Screen.Last.route) {
            LastScreen(navController = navController)
        }
    }

}
