package com.example.mvvm_condosa.screens.caja_chica

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.navigation.AppScreens


@Composable
fun AnadirGastosScreen(
    navController: NavController,
    gradient: Brush
) {
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AnadirGastos(navController)
    }
}

@Composable
fun AnadirGastos(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle_Anadir(colorScheme)
        Spacer(modifier = Modifier.padding(20.dp))
        Formulario_Anadir(navController)
    }
}

@Composable
fun HeaderTitle_Anadir(colorScheme: ColorScheme) {
    Text(
        text = stringResource(id = R.string.añadir_nuevo_gasto),
        color = colorScheme.onPrimary,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 40.sp
    )
}

@Composable
fun Formulario_Anadir(navController: NavController) {
    var fecha by rememberSaveable { mutableStateOf("") }
    val anio: Int
    val mes: Int
    val dia: Int
    val nCalendar = Calendar.getInstance()
    anio = nCalendar.get(Calendar.YEAR)
    mes = nCalendar.get(Calendar.MONTH)
    dia = nCalendar.get(Calendar.DAY_OF_MONTH)

    val nDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, anio: Int, mes: Int, dia:Int ->
            fecha = "$dia/${mes+1}/$anio"
        }, anio, mes, dia
    )

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.Center)) {
            OutlinedTextField(
                value = fecha,
                onValueChange = {fecha = it},
                readOnly = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.selecciona_fecha),
                        color = colorScheme.onSecondary
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = null,
                        modifier = Modifier.clickable { nDatePickerDialog.show() },
                        tint = colorScheme.onPrimary
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

        }
    }

    Spacer(modifier = Modifier.padding(8.dp))

    var descripcionGasto by remember { mutableStateOf("") }
    TextField(
        value = descripcionGasto,
        onValueChange = { descripcionGasto = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = stringResource(R.string.ingrese_producto)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1
    )

    Spacer(modifier = Modifier.padding(8.dp))

    var cantidad by remember { mutableStateOf("") }
    TextField(
        value = cantidad,
        onValueChange = { cantidad = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = stringResource(R.string.ingrese_monto)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1
    )


    Spacer(modifier = Modifier.padding(20.dp))
    ButtonAnadir(navController)
}

@Composable
fun ButtonAnadir(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.RegistroGastosScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.tertiaryContainer)
    ) {
        Text(
            text = stringResource(id = R.string.registrar_gasto),
            fontSize = 20.sp,
            color = colorScheme.onTertiaryContainer
        )
    }
}
