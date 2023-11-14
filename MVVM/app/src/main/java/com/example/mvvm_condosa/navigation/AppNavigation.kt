package com.example.mvvm_condosa.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_condosa.screens.caja_chica.AnadirGastosScreen
import com.example.mvvm_condosa.screens.caja_chica.AsignacionCajaChicaScreen
import com.example.mvvm_condosa.screens.caja_chica.CajaChicaScreen
import com.example.mvvm_condosa.screens.caja_chica.GastosMesAnteriorScreen
import com.example.mvvm_condosa.screens.caja_chica.GastosScreen
import com.example.mvvm_condosa.screens.caja_chica.HistorialCajaChicaScreen
import com.example.mvvm_condosa.screens.caja_chica.RegistroGastosScreen
import com.example.mvvm_condosa.screens.home.HomeScreen
import com.example.mvvm_condosa.screens.login.LoginScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    gradient: Brush
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route
    ) {
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController, gradient)
        }
        composable(route = AppScreens.CajaChicaScreen.route) {
            CajaChicaScreen(navController, gradient)
        }
        composable(route = AppScreens.GastosMesAnteriorScreen.route) {
            GastosMesAnteriorScreen(gradient)
        }
        composable(route = AppScreens.HistorialCajaChicaScreen.route) {
            HistorialCajaChicaScreen(navController, gradient)
        }
        composable(route = AppScreens.RegistroGastosScreen.route) {
            RegistroGastosScreen(navController, gradient)
        }
        composable(route = AppScreens.GastosScreen.route) {
            GastosScreen(gradient)
        }
        composable(route = AppScreens.AnadirGastoScreen.route) {
            AnadirGastosScreen(navController, gradient)
        }

        composable(route = AppScreens.AsignacionCajaChicaSreen.route) {
            AsignacionCajaChicaScreen(navController, gradient)
        }
    }
}