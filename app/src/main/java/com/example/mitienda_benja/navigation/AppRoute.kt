package com.example.mitienda_benja.navigation

//declaramos un conjunto cerrado y seguro de rutas
sealed class AppRoute(val route:String) {
    data object Home:AppRoute("home")
    data object Profile: AppRoute("profile")
    data object Settings: AppRoute("settings")

    data class Detail (val itemId:String): AppRoute("detail/{itemId}")
    {
        fun buildRoute():String{
            return route.replace("{itemId}",itemId)
        }
    }


}