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
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvm_condosa.R
import com.example.mvvm_condosa.ui.navigation.AppScreens
import com.example.mvvm_condosa.ui.theme.DarkColors
import com.example.mvvm_condosa.ui.theme.LightColors
import com.example.mvvm_condosa.ui.theme.Typography
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
        HeaderHome(colorScheme)
        Spacer(modifier = Modifier.padding(12.dp))
        DescriptionHome(colorScheme)
        Spacer(modifier = Modifier.padding(12.dp))
        DataCardsHome()
        Spacer(modifier = Modifier.padding(12.dp))
        ButtonCotiza(colorScheme)
        Spacer(modifier = Modifier.padding(40.dp))
        GraphicHome(colorScheme)
        Spacer(modifier = Modifier.padding(40.dp))
        TitleOptionsHome(colorScheme)
        Spacer(modifier = Modifier.padding(12.dp))
        OptionsHome(navController, colorScheme)
        Spacer(modifier = Modifier.padding(60.dp))
        FooterHome(colorScheme)
        Spacer(modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun HeaderHome(colorScheme: ColorScheme) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.condosa),
            color = colorScheme.onPrimary,
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
fun DescriptionHome(colorScheme: ColorScheme) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(R.string.texto), // 15+ Años de Excelencia en Condominios para Tu Comodidad y Seguridad Inigualables.
            color = colorScheme.onPrimary,
            style = Typography.bodyMedium,


        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = stringResource(R.string.texto_1), // Tu Hogar, Nuestra Pasión
            color = colorScheme.onPrimary,
            fontSize = 30.sp,
            lineHeight = 36.sp
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = stringResource(R.string.texto_2), // ¡Descubre la Diferencia Ahora!
            color = colorScheme.onPrimary,
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
fun ButtonCotiza(colorScheme: ColorScheme) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.primaryContainer)
    ) {
        Text(
            text = stringResource(R.string.texto_3),
            fontSize = 20.sp,
            color = colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun GraphicHome(colorScheme: ColorScheme) {
    Text(
        text = stringResource(R.string.grafico_estadistico),
        color = colorScheme.primary,
        style = Typography.bodyMedium,
    )
}

@Composable
fun TitleOptionsHome(colorScheme: ColorScheme) {
    Text(
        text = stringResource(R.string.opciones_de_administrador),
        color = colorScheme.onPrimary,
        style = Typography.displayMedium,
    )
}

@Composable
fun OptionsHome(navController: NavController, colorScheme: ColorScheme) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.tertiaryContainer)
    ) {
        Text(
            text = stringResource(R.string.opcion_1),
            fontSize = 20.sp,
            color = colorScheme.onTertiaryContainer
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.tertiaryContainer)
    ) {
        Text(
            text = stringResource(R.string.opcion_2),
            fontSize = 20.sp,
            color = colorScheme.onTertiaryContainer
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { navController.navigate(route = AppScreens.CajaChicaScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.tertiaryContainer)
    ) {
        Text(
            text = stringResource(R.string.revision_de_caja_chica),
            fontSize = 20.sp,
            color = colorScheme.onTertiaryContainer
        )
    }
    Spacer(modifier = Modifier.padding(8.dp))
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(colorScheme.tertiaryContainer)
    ) {
        Text(
            text = stringResource(R.string.opcion_4),
            fontSize = 20.sp,
            color = colorScheme.onTertiaryContainer
        )
    }
}

@Composable
fun FooterHome(colorScheme: ColorScheme) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo_ejemplo),
            contentDescription = "Logo app"
        )
        Text(
            text = stringResource(R.string.texto_4),
            fontSize = 10.sp,
            color = colorScheme.onPrimary
        )
    }
}
