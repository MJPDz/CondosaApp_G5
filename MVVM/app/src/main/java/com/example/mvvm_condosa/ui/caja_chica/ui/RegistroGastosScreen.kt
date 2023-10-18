package com.example.mvvm_condosa.ui.caja_chica.ui

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm_condosa.data.GastosCasaSource.gastosCasa
import com.example.mvvm_condosa.data.GastosMesAnteriorSource.gastosMesAnterior
import com.example.mvvm_condosa.ui.navigation.AppScreens


@Composable
fun RegistroGastosScreen(navController: NavController) {
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
        RegistroGastos(navController)
    }
}

@Composable
fun RegistroGastos(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle_Registro()
        Spacer(modifier = Modifier.padding(20.dp))
        InfoRegistros()
        Spacer(modifier = Modifier.padding(20.dp))
        OptionsRegistro(navController)
    }
}

@Composable
fun HeaderTitle_Registro() {
    Text(
        text = "Registro de Gastos",
        color = Color.White,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 40.sp
    )
}

@Composable
fun InfoRegistros() {
    var gastoTotal = 0
    gastosMesAnterior.forEach { gastoAnterior ->
        gastoTotal  += gastoAnterior.gasto
    }
    var cajaChica = (gastoTotal*0.25).toInt()

    var consumido = 0
    gastosCasa.forEach { gastosCasa ->
        consumido += gastosCasa.monto
    }
    var restante = cajaChica - consumido

    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Caja chica",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = "asignada:",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            Text(
                text = "S/ ${cajaChica}.00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD1C484),
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Consumido:",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = "S/ ${consumido}.00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD1C484),
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Restante:",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = "S/ ${restante}.00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD1C484),
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}

@Composable
fun OptionsRegistro(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.AnadirGastoScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Registrar nuevo gasto",
            fontSize = 20.sp,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.GastosScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Ver gastos",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
