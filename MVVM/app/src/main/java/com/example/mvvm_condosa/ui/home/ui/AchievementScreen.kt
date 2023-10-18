package com.example.mvvm_condosa.ui.home.ui

import androidx.compose.foundation.background
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

@Preview(showBackground = true)
@Composable
fun AchievementCard(modifier: Modifier = Modifier) {
    val gradient = Brush.linearGradient(
        0.0f to Color(0xFF4B7DCE),
        1000.0f to Color(0xFF0C3577),
        start = Offset.Zero,
        end = Offset.Infinite
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
                        .background(gradient)
                        .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "58",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = "Condominios",
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 8.dp)){
                Box(modifier = Modifier
                    .background(gradient)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "49",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = "Condominios",
                            fontSize = 14.sp,
                            color = Color.White,
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
                    .background(gradient)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "26",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = "Condominios",
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 8.dp)){
                Box(modifier = Modifier
                    .background(gradient)
                    .padding(15.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "34",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = "Condominios",
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
