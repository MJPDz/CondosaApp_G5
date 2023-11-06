package com.example.mvvm_condosa.ui.theme



import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mvvm_condosa.R

private val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_italic, style = FontStyle.Italic),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_black, weight = FontWeight.Black),
)
/*
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )   --- esta parte de arriba estaba en uso
     Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)
*/

val AbrilFatface = FontFamily(
    Font(R.font.abril_fatface_regular)
)



val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val Typography = Typography(

    displayLarge = TextStyle(    //  displayLarge  => mostrar en grande
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp,
        letterSpacing = 0.5.sp

    ),
    displayMedium = TextStyle(    //  displayMedium => monstrar tamaño medio
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(     // etiqueta pequeña
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(   // cuerpo grande
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    bodyMedium = TextStyle(   // cuerpo grande
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )




)

