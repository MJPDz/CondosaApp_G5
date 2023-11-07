package com.example.mvvm_condosa.ui.caja_chica.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.data.GastosCasaSource.gastosCasa
import com.example.mvvm_condosa.model.GastosCasa
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Preview
@Composable
fun GastosScreen() {
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
    ) {
        Gastos()
    }
}

@Composable
fun Gastos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTitle_GastosCasa(colorScheme)
        FiltrarGastosAnioYMes(colorScheme)
        Spacer(modifier = Modifier.padding(12.dp))
        ListaGastos_Casa()
    }
}

@Composable
fun FiltrarGastosAnioYMes(colorScheme: ColorScheme) {
    var expandedAnio by remember { mutableStateOf(false) }
    val listAnio = listOf("2023", "2022", "2021", "2020", "2019")
    var selectedItemAnio by remember { mutableStateOf("") }

    var expandedMes by remember { mutableStateOf(false) }
    val listMes = listOf(
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"
    )
    var selectedItemMes by remember { mutableStateOf("") }

    val density = LocalDensity.current.density

    var textFieldSizeAnio by remember { mutableStateOf(0f) }
    var textFieldSizeMes by remember { mutableStateOf(0f) }

    Row(
        modifier = Modifier.padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = selectedItemAnio,
            onValueChange = { newItem -> selectedItemAnio = newItem },
            modifier = Modifier.weight(1f)
                .onGloballyPositioned { coordinates ->
                    val widthInPixels = coordinates.size.width
                    textFieldSizeAnio = widthInPixels / density
                },
            label = {
                Text(
                    text = stringResource(id = R.string.año),
                    color = colorScheme.onPrimary
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (expandedAnio) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expandedAnio = !expandedAnio },
                    tint = colorScheme.primary
                )
            }
        )

        Spacer(modifier = Modifier.width(12.dp))

        OutlinedTextField(
            value = selectedItemMes,
            onValueChange = { newItem -> selectedItemMes = newItem },
            modifier = Modifier.weight(1f)
                .onGloballyPositioned { coordinates ->
                    val widthInPixels = coordinates.size.width
                    textFieldSizeMes = widthInPixels / density
                },
            label = {
                Text(
                    text = stringResource(id = R.string.mes),
                    color = colorScheme.onPrimary
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (expandedMes) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expandedMes = !expandedMes },
                    tint = colorScheme.primary
                )
            }
        )
    }

    if (expandedAnio) {
        DropdownMenu(
            expanded = expandedAnio,
            onDismissRequest = { expandedAnio = false },
            modifier = Modifier.width(with(density) { textFieldSizeAnio.dp })
        ) {
            listAnio.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = label,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onClick = {
                        selectedItemAnio = label
                        expandedAnio = false
                    }
                )
            }
        }
    }

    if (expandedMes) {
        DropdownMenu(
            expanded = expandedMes,
            onDismissRequest = { expandedMes = false },
            modifier = Modifier.width(with(density) { textFieldSizeMes.dp })
        ) {
            listMes.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = label,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onClick = {
                        selectedItemMes = label
                        expandedMes = false
                    }
                )
            }
        }
    }
}



@Composable
fun HeaderTitle_GastosCasa(colorScheme: ColorScheme) {
    Text(
        text = stringResource(R.string.gastos_de_caja_chica),
        color = colorScheme.onPrimary,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 36.sp
    )
}

@Composable
fun ListaGastos_Casa() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(gastosCasa) { item ->
            ListGastosRow(item)
        }
    }
}

@Composable
fun ListGastosRow(item: GastosCasa, modifier: Modifier = Modifier) {
    val colorScheme = if (isSystemInDarkTheme()) {
        DarkColors
    } else {
        LightColors
    }

    Box(
        modifier = modifier
            .background(colorScheme.secondaryContainer)
    )

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_medium))
    ) {
        Box(modifier = Modifier
            .background(colorScheme.tertiaryContainer)
            .padding(15.dp)
        ) {
            Column (
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
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
                            text = item.fecha,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onTertiaryContainer
                        )
                        Text(
                            text = item.nombre,
                            fontSize = 16.sp,
                            color = colorScheme.onTertiaryContainer
                        )
                        Text(
                            text = item.producto,
                            fontSize = 16.sp,
                            color = colorScheme.onTertiaryContainer
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        GastoItemButton(
                            expanded = expanded,
                            onClick = { expanded = !expanded }
                        )
                        Text(
                            text = stringResource(R.string.monto_result, item.monto),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onTertiaryContainer
                        )
                    }
                }
                if (expanded) {
                    GastoItemExtend()
                }
            }
        }
    }
}

@Composable
private fun GastoItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = "Boton Expandir",
            tint = colorScheme.onTertiaryContainer
        )
    }
}

@Composable
fun GastoItemExtend() {
    Text(
        text = stringResource(R.string.mas_info),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = colorScheme.onPrimary
    )
    Text(
        text = stringResource(R.string.mas_info_1),
        fontSize = 16.sp,
        color = colorScheme.onTertiaryContainer
    )
    Text(
        text = stringResource(R.string.mas_info_2),
        fontSize = 16.sp,
        color = colorScheme.onTertiaryContainer
    )
}
