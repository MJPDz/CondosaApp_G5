package com.example.mvvm_condosa.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mvvm_condosa.navigation.AppScreens

sealed class Items_menu_lateral(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    object Item_menu_lateral1: Items_menu_lateral(
        Icons.Default.Home,
        "Home",
        AppScreens.HomeScreen.route
    )
    object Item_menu_lateral2: Items_menu_lateral(
        Icons.Default.AccountCircle,
        "Perfil de usuario",
        "" // Ruta vacía - No redirige
    )
    object Item_menu_lateral3: Items_menu_lateral(
        Icons.Default.AttachMoney,
        "Caja chica",
        AppScreens.CajaChicaScreen.route
    )
    object Item_menu_lateral4: Items_menu_lateral(
        Icons.Default.Settings,
        "Opciones",
        "" // Ruta vacía - No redirige
    )
    object Item_menu_lateral5: Items_menu_lateral(
        Icons.Default.ExitToApp,
        "Cerrar sesión",
        AppScreens.LoginScreen.route
    )
}
