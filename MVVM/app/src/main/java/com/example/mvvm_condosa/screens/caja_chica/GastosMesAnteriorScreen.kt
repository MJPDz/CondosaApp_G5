package com.example.mvvm_condosa.screens.caja_chica

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
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.data.GastosMesAnteriorSource.gastosMesAnterior
import com.example.mvvm_condosa.data.model.GastosMesAnterior
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Composable
fun GastosMesAnteriorScreen(gradient: Brush) {
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
        HeaderTitle_MesAnterior(colorScheme)
        Spacer(modifier = Modifier.padding(20.dp))
        ListaGastos_MesAnterior()
    }
}

@Composable
fun HeaderTitle_MesAnterior(colorScheme: ColorScheme) {
    Text(
        text = stringResource(id = R.string.gastos_del_mes_anterior_1),
        color = colorScheme.onPrimary,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 36.sp
    )
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
fun ListItemRow(item: GastosMesAnterior, modifier: Modifier = Modifier) {
    val colorScheme = if (isSystemInDarkTheme()) {
        DarkColors
    } else {
        LightColors
    }

    Box(
        modifier = modifier
            .background(colorScheme.secondaryContainer), // Establece el color de fondo aquí
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium))
    ){
        Box(modifier = Modifier
            .background(colorScheme.secondaryContainer)
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
                        text = stringResource(R.string.numero_nro, item.numero),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = item.nombre,
                        fontSize = 14.sp,
                        color = colorScheme.onSecondaryContainer
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.gasto_result, item.gasto),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onTertiaryContainer,
                    )
                }
            }
        }
    }
}