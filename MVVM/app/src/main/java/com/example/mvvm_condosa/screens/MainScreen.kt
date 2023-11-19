package com.example.mvvm_condosa.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_condosa.MainViewModel
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.components.MenuLateral
import com.example.mvvm_condosa.components.NavegacionInferior
import com.example.mvvm_condosa.components.TopBar
import com.example.mvvm_condosa.navigation.AppNavigation
import com.example.mvvm_condosa.navigation.currentRoute
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val colorScheme = if (isSystemInDarkTheme()) {
        DarkColors
    } else {
        LightColors
    }

    val gradient = Brush.linearGradient(
        0.0f to colorScheme.primary,
        1000.0f to colorScheme.primaryContainer,
        start = Offset.Zero,
        end = Offset.Infinite
    )

    if(currentRoute(navController) == "login_screen"){
        AppNavigation(navController, gradient)
    }
    else {
        MenuLateral(
            navController = navController,
            drawerState = drawerState
        ) {
            Contenido(
                navController = navController,
                drawerState = drawerState,
                gradient = gradient
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contenido(
    navController: NavHostController,
    drawerState: DrawerState,
    gradient: Brush
) {
    val mainViewModel: MainViewModel = viewModel()
    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                drawerState = drawerState
            )
        },
        bottomBar = {
            NavegacionInferior(navController)
        }
    ) { padding->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            AppNavigation(navController, gradient)
        }
        if(mainViewModel.showBottomSheet){
            ModalBottomSheet(
                onDismissRequest = { mainViewModel.showBottomSheet = false }
            ) {
                ContentBottomSheet()
            }
        }
    }
}

@Composable
fun ContentBottomSheet() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(horizontal = 28.dp)
    ) {
        Text(text = stringResource(R.string.proyecto_condosa))
        Text(text = stringResource(R.string.trabajo_del_curso_de_desarrollo_de_sistemas_m_viles_2023_2))
        Text(text = stringResource(R.string.integrantes_g5))
        Text(text = stringResource(R.string.anchahua_flores_maricielo))
        Text(text = stringResource(R.string.barrenechea_benites_balya_agnes))
        Text(text = stringResource(R.string.portugal_de_la_cruz_marko_joel))
        Text(text = stringResource(R.string.urbano_quispe_adrian_rodrigo))
        Text(text = stringResource(R.string.docente))
        Text(text = stringResource(R.string.mamani_rodriguez_zoraida_emperatriz))
        Text(text = stringResource(R.string.escuela_profesional_de_ingenier_a_de_sistemas))
        Text(text = stringResource(R.string.fisi_unmsm))
    }
}