package com.example.mvvm_condosa.screens.caja_chica

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mvvm_condosa.MainViewModel
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.navigation.AppScreens

@Composable
fun AsignacionCajaChicaScreen(
    navController: NavController,
    gradient: Brush
) {
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsignacionCajaChica(navController)
    }
}

@Composable
fun AsignacionCajaChica(navController: NavController) {
    val mainViewModel: MainViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderAsignacion(colorScheme)
        Spacer(modifier = Modifier.padding(40.dp))
        Sugerencia(colorScheme)
        Spacer(modifier = Modifier.padding(20.dp))
        CardCajaChica(colorScheme)
        Spacer(modifier = Modifier.padding(40.dp))
        OptionsAsignacion(navController, colorScheme)
        if(mainViewModel.showDialogAsignacion){
            DialogoAsignacion(mainViewModel, colorScheme)
        }
    }
}

@Composable
fun DialogoAsignacion(mainViewModel: MainViewModel, colorScheme: ColorScheme) {
    var cantidad by remember { mutableStateOf("") }
    var acepto by remember { mutableStateOf(false) }

    AlertDialog(
        icon = {
           Icon(
               imageVector = Icons.Default.AttachMoney,
               contentDescription = null
           )
        },
        title = {
            Text(text = "Asignar Caja Chica")
        },
        text = {
           Column {
               Text(text = "Ingresa el nuevo monto de caja chica")
               Spacer(modifier = Modifier.padding(8.dp))
               TextField(
                   value = cantidad,
                   onValueChange = {cantidad = it},
                   placeholder = {
                       Text(text = "Ingresar monto")
                   },
                   keyboardOptions = KeyboardOptions(
                       keyboardType = KeyboardType.Number
                   )
               )
               Spacer(modifier = Modifier.padding(8.dp))
               Row(
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Checkbox(
                       checked = acepto,
                       onCheckedChange = {acepto = it}
                   )
                   Text(text = "Cuento con el permiso necesario")
               }
           }
        },
        onDismissRequest = {
            mainViewModel.showDialogAsignacion = false
        },
        confirmButton = { 
            TextButton(
                onClick = { mainViewModel.showDialogAsignacion = false }
            ) {
                Text(text = "Registrar")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { mainViewModel.showDialogAsignacion = false }
            ) {
                Text(text = "Cancelar")
            }
        }
    )
}

@Composable
fun OptionsAsignacion(navController: NavController, colorScheme: ColorScheme) {
    Button(
        onClick = { navController.navigate(route = AppScreens.HistorialCajaChicaScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = "Ver historial de caja chica",
            fontSize = 20.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.GastosMesAnteriorScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = "Ver gastos del mes anterior",
            fontSize = 20.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
}

@Composable
fun CardCajaChica(colorScheme: ColorScheme) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium))
    ) {
        Box(modifier = Modifier
            .background(colorScheme.tertiaryContainer)
            .padding(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Column {
                    Text(
                        text = "Caja chica:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorScheme.onTertiaryContainer
                    )
                    Text(
                        text = "S/ 1500.00",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onTertiaryContainer
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                ModificarCajaChica(colorScheme)
            }
        }
    }
}

@Composable
fun ModificarCajaChica(colorScheme: ColorScheme) {
    val mainViewModel: MainViewModel = viewModel()
    Button(
        onClick = {
            mainViewModel.showDialogAsignacion = true
        },
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = "Modificar",
            fontSize = 14.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
}

@Composable
fun Sugerencia(colorScheme: ColorScheme) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Monto sugerido:",
            fontSize = 16.sp,
            color = colorScheme.onPrimary
        )
        Text(
            text = "S/ 900.00",
            fontSize = 16.sp,
            color = colorScheme.onPrimary
        )
    }
}

@Composable
fun HeaderAsignacion(colorScheme: ColorScheme) {
    Text(
        text = "Asignacion de caja chica",
        color = colorScheme.onPrimary ,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}


















