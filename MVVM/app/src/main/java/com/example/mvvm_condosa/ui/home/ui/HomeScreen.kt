package com.example.mvvm_condosa.ui.home.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.ui.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController) {
    val gradient = Brush.linearGradient(
        0.0f to Color(0xFF0052D6),
        1000.0f to Color(0xFF00183F),
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient)){
        Home(navController)
    }
}

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderHome()
        Spacer(modifier = Modifier.padding(12.dp))
        DescriptionHome()
        Spacer(modifier = Modifier.padding(12.dp))
        DataCardsHome()
        Spacer(modifier = Modifier.padding(12.dp))
        ButtonCotiza()
        Spacer(modifier = Modifier.padding(40.dp))
        GraphicHome()
        Spacer(modifier = Modifier.padding(40.dp))
        TitleOptionsHome()
        Spacer(modifier = Modifier.padding(12.dp))
        OptionsHome(navController)
        Spacer(modifier = Modifier.padding(60.dp))
        FooterHome()
        Spacer(modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun HeaderHome() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Condosa",
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier.align(CenterVertically),
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(R.drawable.logo_ejemplo),
            contentDescription = "logo app"
        )
    }
}

@Composable
fun DescriptionHome() {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "15+ Años de Excelencia en Condominios para Tu Comodidad y Seguridad Inigualables.",
            color = Color(0xFFACACAC),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Tu Hogar, Nuestra Pasión",
            color = Color.White,
            fontSize = 30.sp,
            lineHeight = 36.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "¡Descubre la Diferencia Ahora!",
            color = Color(0xFFF1710E),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DataCardsHome() {
    AchievementCard()
}

@Composable
fun ButtonCotiza() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "¡Cotiza nuestro servicio!",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun GraphicHome() {
    Text(
        text = "Gráfico estadistico...",
        color = Color(0xFFACACAC),
        fontSize = 20.sp
    )
}

@Composable
fun TitleOptionsHome() {
    Text(
        text = "Opciones de Administrador",
        color = Color(0xFFD1C484),
        fontSize = 20.sp
    )
}

@Composable
fun OptionsHome(navController: NavController) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Opción 1",
            fontSize = 20.sp,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Opción 2",
            fontSize = 20.sp,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.CajaChicaScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Revisión de caja chica",
            fontSize = 20.sp,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(
            text = "Opción 4",
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun FooterHome() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo_ejemplo),
            contentDescription = "Logo app"
        )
        Text(
            text ="Condominios S.A. © 2023",
            fontSize = 10.sp,
            color = Color.White
        )
    }
}
