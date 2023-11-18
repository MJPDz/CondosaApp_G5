package com.example.mvvm_condosa.screens.caja_chica

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.data.DAO.PredioDAO
import com.example.mvvm_condosa.navigation.AppScreens
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Composable
fun CajaChicaScreen(
    navController: NavController,
    gradient: Brush
) {
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CajaChica(navController)
    }
}

@Composable
fun CajaChica(navController: NavController) {
    val PredioDAO = PredioDAO()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle(colorScheme)
        Spacer(modifier = Modifier.padding(40.dp))
        SelectedPredio(colorScheme, PredioDAO)
        Spacer(modifier = Modifier.padding(80.dp))
        OptionsCaja(navController, colorScheme)
    }
}

@Composable
fun HeaderTitle(colorScheme : ColorScheme) {
    Text(
        text = stringResource(id = R.string.caja_chica),
        color = colorScheme.onPrimary ,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SelectedPredio(colorScheme : ColorScheme, predioDAO: PredioDAO) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var prediosList by remember { mutableStateOf(emptyList<String>()) }

    // Obtener la lista de descripciones de predios desde el DAO
    prediosList = predioDAO.obtenerPrediosSinRepetir()

    val icon = if (expanded) {
        Icons.Default.KeyboardArrowUp
    } else {
        Icons.Default.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = { newItem -> selectedItem = newItem },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {
                Text(
                    text = stringResource(id = R.string.selecciona_un_predio),
                    color = colorScheme.onPrimary
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded },
                    tint = colorScheme.primary
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            prediosList.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = label,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onClick = {
                        selectedItem = label
                        expanded = false
                    }
                )
            }
        }
    }
}


@Composable
fun OptionsCaja(navController: NavController, colorScheme : ColorScheme) {
    Button(
        onClick = { navController.navigate(route = AppScreens.AsignacionCajaChicaSreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = "Asignación de caja chica",
            fontSize = 20.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.RegistroGastosScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = stringResource(id = R.string.registro_de_gastos),
            fontSize = 20.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
}
