package com.example.learncompose.Navigations

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Second : Screen("second")
    object Last : Screen("last")
    /*4- sealed class with arg*/
    fun withArg(vararg params: Any): String {
        return buildString {
            append(route)
            params.forEach {
                append("/$it")
            }
        }
    }
}