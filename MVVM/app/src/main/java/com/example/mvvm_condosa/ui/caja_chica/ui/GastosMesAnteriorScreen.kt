package com.example.mvvm_condosa.ui.caja_chica.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.data.GastosMesAnteriorSource.gastosMesAnterior
import com.example.mvvm_condosa.model.GastosMesAnterior
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Preview
@Composable
fun GastosMesAnteriorScreen() {
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

    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        GastosMesAnterior()
    }
}

@Composable
fun GastosMesAnterior() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle_MesAnterior()
        Spacer(modifier = Modifier.padding(20.dp))
        InfoCajaChica()
        Spacer(modifier = Modifier.padding(20.dp))
        ListaGastos_MesAnterior()
    }
}

@Composable
fun HeaderTitle_MesAnterior() {
    Text(
        text = "Gastos del mes anterior",
        color = LocalContentColor.current,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 36.sp
    )
}

@Composable
fun InfoCajaChica() {
    var gastoTotal = 0
    gastosMesAnterior.forEach {gastoAnterior ->
        gastoTotal  += gastoAnterior.gasto
    }
    var cajaChica = (gastoTotal*0.25).toInt()

    Column(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Gasto Total",
                    fontSize = 16.sp,
                    color = LocalContentColor.current
                )
                Text(
                    text = "del mes anterior:",
                    fontSize = 16.sp,
                    color = LocalContentColor.current
                )
            }
            Text(
                text = "S/ ${gastoTotal}.00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = LocalContentColor.current,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Caja chica",
                    fontSize = 16.sp,
                    color = LocalContentColor.current
                )
                Text(
                    text = "asignada:",
                    fontSize = 16.sp,
                    color = LocalContentColor.current
                )
            }
            Text(
                text = "S/ ${cajaChica}.00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = LocalContentColor.current,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}

@Composable
fun ListaGastos_MesAnterior() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(gastosMesAnterior) {
            item -> ListItemRow(item)
        }
    }
}

@Composable
fun ListItemRow(item: GastosMesAnterior) {
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

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium))
    ){
        Box(modifier = Modifier
            .background(gradient)
            .padding(15.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Column {
                    Text(
                        text = "Nro: ${item.numero}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = LocalContentColor.current
                    )
                    Text(
                        text = item.nombre,
                        fontSize = 14.sp,
                        color = LocalContentColor.current
                    )
                }
                Column {
                    Text(
                        text = "S/ ${item.gasto}.00",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = LocalContentColor.current,
                    )
                }
            }
        }
    }
}