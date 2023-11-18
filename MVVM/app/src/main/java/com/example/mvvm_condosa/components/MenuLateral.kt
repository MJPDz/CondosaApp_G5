package com.example.mvvm_condosa.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.data.model.Items_menu_lateral.*
import com.example.mvvm_condosa.navigation.currentRoute
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(
    navController: NavHostController,
    drawerState: DrawerState,
    contenido: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val menu_items = listOf(
        Item_menu_lateral1,
        Item_menu_lateral2,
        Item_menu_lateral3,
        Item_menu_lateral4,
        Item_menu_lateral5
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painter = painterResource(R.drawable.logo_ejemplo),
                    contentDescription = null
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )  {
                    Image(
                        painter = painterResource(R.drawable.user),
                        contentDescription = null
                    )
                    Text(
                        text = "Pedro Castillo",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    Text(text = "Administrador")
                }
                menu_items.forEach { item->
                    val selected = currentRoute(navController) == item.ruta
                    NavigationDrawerItem(
                        modifier = Modifier.padding(10.dp),
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = item.title) },
                        selected = selected,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            if(item.ruta !== "") navController.navigate(item.ruta)
                        }
                    )
                }
            }
        }
    ) {
        contenido()
    }
}