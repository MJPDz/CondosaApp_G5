package com.example.mvvm_condosa.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mvvm_condosa.navigation.AppScreens

sealed class Items_bottom_nav(
    val icon: ImageVector,
    val title: String,
    val ruta: String
){
    object Item_bottom_nav1: Items_bottom_nav(
        Icons.Default.Home,
        "Home",
        AppScreens.HomeScreen.route
    )
    object Item_bottom_nav2: Items_bottom_nav(
        Icons.Default.AttachMoney,
        "Caja chica",
        AppScreens.CajaChicaScreen.route
    )
    object Item_bottom_nav3: Items_bottom_nav(
        Icons.Default.ExitToApp,
        "Salir",
        AppScreens.LoginScreen.route
        
    )
}