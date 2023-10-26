package com.example.mvvm_condosa.ui.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.LocalContentColor
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
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors

@Composable
fun HomeScreen(navController: NavController) {
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
            color = LocalContentColor.current,
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
            color = LocalContentColor.current,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Tu Hogar, Nuestra Pasión",
            color = LocalContentColor.current,
            fontSize = 30.sp,
            lineHeight = 36.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "¡Descubre la Diferencia Ahora!",
            color = LocalContentColor.current,
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
        colors = ButtonDefaults.buttonColors(LocalContentColor.current)
    ) {
        Text(
            text = "¡Cotiza nuestro servicio!",
            fontSize = 20.sp,
            color = LocalContentColor.current
        )
    }
}

@Composable
fun GraphicHome() {
    Text(
        text = "Gráfico estadistico...",
        color = LocalContentColor.current,
        fontSize = 20.sp
    )
}

@Composable
fun TitleOptionsHome() {
    Text(
        text = "Opciones de Administrador",
        color = LocalContentColor.current,
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
        colors = ButtonDefaults.buttonColors(LocalContentColor.current)
    ) {
        Text(
            text = "Opción 1",
            fontSize = 20.sp,
            color = LocalContentColor.current
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(LocalContentColor.current)
    ) {
        Text(
            text = "Opción 2",
            fontSize = 20.sp,
            color = LocalContentColor.current
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.CajaChicaScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(LocalContentColor.current)
    ) {
        Text(
            text = "Revisión de caja chica",
            fontSize = 20.sp,
            color = LocalContentColor.current
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(LocalContentColor.current)
    ) {
        Text(
            text = "Opción 4",
            fontSize = 20.sp,
            color = LocalContentColor.current
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
            color = LocalContentColor.current
        )
    }
}
