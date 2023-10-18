package com.example.mvvm_condosa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_condosa.ui.caja_chica.ui.AnadirGastosScreen
import com.example.mvvm_condosa.ui.caja_chica.ui.CajaChicaScreen
import com.example.mvvm_condosa.ui.caja_chica.ui.GastosMesAnteriorScreen
import com.example.mvvm_condosa.ui.caja_chica.ui.GastosScreen
import com.example.mvvm_condosa.ui.caja_chica.ui.RegistroGastosScreen
import com.example.mvvm_condosa.ui.home.ui.HomeScreen
import com.example.mvvm_condosa.ui.login.ui.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = AppScreens.CajaChicaScreen.route) {
            CajaChicaScreen(navController)
        }
        composable(route = AppScreens.GastosMesAnteriorScreen.route) {
            GastosMesAnteriorScreen()
        }
        composable(route = AppScreens.RegistroGastosScreen.route) {
            RegistroGastosScreen(navController)
        }
        composable(route = AppScreens.GastosScreen.route) {
            GastosScreen()
        }
        composable(route = AppScreens.AnadirGastoScreen.route) {
            AnadirGastosScreen(navController)
        }
    }
}