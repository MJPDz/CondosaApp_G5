package com.example.mvvm_condosa.ui.home.ui

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.data.AchievementSource
import com.example.mvvm_condosa.model.Achievement
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Preview(showBackground = true)
@Composable
fun AchievementCard(modifier: Modifier = Modifier) {
    val colorScheme = if (isSystemInDarkTheme()) {
        DarkColors
    } else {
        LightColors
    }

    Box(
        modifier = modifier
            .background(colorScheme.secondaryContainer), // Establece el color de fondo aquí
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(modifier = Modifier.padding(end = 8.dp)){
                Box(modifier = Modifier
                    .background(colorScheme.secondary)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.nro_condominios),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = stringResource(R.string.condominios),
                            fontSize = 14.sp,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 8.dp)){
                Box(modifier = Modifier
                    .background(colorScheme.secondary)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.nro_condominios_1),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = stringResource(R.string.condominios_1),
                            fontSize = 14.sp,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(modifier = Modifier.padding(end = 8.dp)){
                Box(modifier = Modifier
                    .background(colorScheme.secondary)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.nro_condominios_2),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = stringResource(R.string.condominios_2),
                            fontSize = 14.sp,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 8.dp)){
                Box(modifier = Modifier
                    .background(colorScheme.secondary)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.nro_condominios_3),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = stringResource(R.string.condominios_3),
                            fontSize = 14.sp,
                            color = colorScheme.onSecondary,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
