package com.example.mvvm_condosa.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_condosa.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.example.mvvm_condosa.ui.navigation.AppScreens

@Composable
fun LoginScreen(navController: NavController) {
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
        Login( Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Login(modifier: Modifier, navController: NavController) {
    Column(
        modifier = Modifier
    ) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(8.dp))
        HeaderText()
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(16.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(navController)
    }
}

@Composable
fun HeaderText() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Condosa",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "¡ Administración de condominios !",
            fontSize = 30.sp,
            color = Color(0xFFACACAC),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreens.HomeScreen.route) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF00183F))
    ) {
        Text(text = "Iniciar Sesión", fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "¿Olvidaste tu contraseña?",
        modifier = modifier.clickable {  },
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFF1710E)
    )
}

@Composable
fun PasswordField() {
    var firstText by remember { mutableStateOf("") }
    TextField(
        value = firstText,
        onValueChange = { firstText = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun EmailField() {
    var firstText by remember { mutableStateOf("") }
    TextField(
        value = firstText,
        onValueChange = { firstText = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Correo") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.logo_ejemplo),
        contentDescription = "header",
        modifier = modifier
    )
}

