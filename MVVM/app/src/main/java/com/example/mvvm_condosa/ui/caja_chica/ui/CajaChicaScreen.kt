package com.example.mvvm_condosa.ui.caja_chica.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.mvvm_condosa.ui.navigation.AppScreens

@Composable
fun CajaChicaScreen(navController: NavController) {
    val gradient = Brush.linearGradient(
        0.0f to Color(0xFF0052D6),
        1000.0f to Color(0xFF00183F),
        start = Offset.Zero,
        end = Offset.Infinite
    )

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle()
        Spacer(modifier = Modifier.padding(40.dp))
        SelectedPredio()
        Spacer(modifier = Modifier.padding(80.dp))
        OptionsCaja(navController)
    }
}

@Composable
fun HeaderTitle() {
    Text(
        text = "Caja Chica",
        color = Color.White,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SelectedPredio() {
    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Predio 1", "Predio 2", "Predio 3", "Predio 4", "Predio 5")
    var selectedItem by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

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
                    text = "Selecciona un predio",
                    color = Color(0xFFACACAC)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded },
                    tint = Color(0xFFACACAC)
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            list.forEach { label ->
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
fun OptionsCaja(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.GastosMesAnteriorScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Gastos del mes anterior",
            fontSize = 20.sp,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.RegistroGastosScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Registro de gastos",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
