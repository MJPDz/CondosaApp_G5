package com.example.mvvm_condosa.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("Home_screen")
    object CajaChicaScreen: AppScreens("cajaChica_screen")
    object GastosMesAnteriorScreen: AppScreens("gastosMesAnterior_screen")
    object RegistroGastosScreen: AppScreens("registroGastos_screen")
    object AnadirGastoScreen: AppScreens("anadirGasto_screen")
    object GastosScreen: AppScreens("gastos_screen")
    object HistorialCajaChicaScreen: AppScreens("historial_caja_chica_screen")

    object AsignacionCajaChicaSreen: AppScreens("asignacion_caja_chica_screen")
}
