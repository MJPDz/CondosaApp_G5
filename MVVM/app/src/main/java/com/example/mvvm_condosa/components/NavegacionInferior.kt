package com.example.mvvm_condosa.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.mvvm_condosa.data.model.Items_bottom_nav.*
import com.example.mvvm_condosa.navigation.currentRoute

@Composable
fun NavegacionInferior(
    navController: NavHostController
) {
    val menu_items = listOf(
        Item_bottom_nav1,
        Item_bottom_nav2,
        Item_bottom_nav3
    )
    BottomAppBar{
        NavigationBar {
            menu_items.forEach { item->
                val selected = currentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        if(item.ruta !== "") navController.navigate(item.ruta)
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    }
                )
            }
        }
    }
}