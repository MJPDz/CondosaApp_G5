package com.example.mvvm_condosa.screens.caja_chica

import RegistroDAO
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.navigation.AppScreens


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegistroGastosScreen(
    navController: NavController,
    gradient: Brush,
    id: Int?
) {
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        RegistroGastos(navController, id)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegistroGastos(
    navController: NavController,
    id: Int?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle_Registro(colorScheme)
        Spacer(modifier = Modifier.padding(20.dp))
        if (id != null) {
            InfoRegistros(colorScheme,id)
        }
        Spacer(modifier = Modifier.padding(20.dp))
        OptionsRegistro(navController, colorScheme, id)
    }
}

@Composable
fun HeaderTitle_Registro(colorScheme: ColorScheme) {
    Text(
        text = stringResource(R.string.registro_de_gastos_1),
        color = colorScheme.onPrimary,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 40.sp
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InfoRegistros(colorScheme: ColorScheme, predio : Int) {
    var cajaChica = RegistroDAO().obtenerCajachica(predio)
    var idCajaChica = RegistroDAO().obtenerIdCajachica(predio)
    var consumido = RegistroDAO().calcularConsumo(predio)
    var restante = cajaChica - consumido

    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(R.string.caja_chica_2),
                    fontSize = 16.sp,
                    color = colorScheme.onPrimary
                )
                Text(
                    text = stringResource(R.string.asignada_1),
                    fontSize = 16.sp,
                    color = colorScheme.onPrimary
                )
            }
            Text(
                text = stringResource(R.string.caja_chica_result_1, cajaChica),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorScheme.onPrimary,
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
                text = stringResource(R.string.consumido),
                fontSize = 16.sp,
                color = colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = stringResource(R.string.consumido_result_1, consumido),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorScheme.onPrimary,
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
                text = stringResource(R.string.restante),
                fontSize = 16.sp,
                color = colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = stringResource(R.string.restante_result, restante),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}

@Composable
fun OptionsRegistro(
    navController: NavController,
    colorScheme: ColorScheme,
    id: Int?
) {
    Button(
        onClick = { navController.navigate(route = AppScreens.AnadirGastoScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = stringResource(R.string.registrar_nuevo_gasto),
            fontSize = 20.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.GastosScreen.route +"/${id}") },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.secondaryContainer)
    ) {
        Text(
            text = stringResource(R.string.ver_gastos),
            fontSize = 20.sp,
            color = colorScheme.onSecondaryContainer
        )
    }
}