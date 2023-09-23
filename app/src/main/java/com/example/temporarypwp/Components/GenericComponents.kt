package com.example.temporarypwp.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenericButton(
    onClick: () -> Unit,
    colors: ButtonColors,
    height: Int,
    width: Int,
    text: String?,
    imagePainter: Int?
) {

    Button(
        onClick = onClick,
        colors = colors,
        modifier = Modifier
            .size(width.dp, height.dp)


    ) {
        if (text != null) {
            Text(text)
        }
        if (imagePainter != null) {
            Image(painter = painterResource(id = imagePainter), contentDescription = "")
        }
    }

}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GenericText(
    text: String,
    sp: Int,
    fontWeight: FontWeight,
    color: Color,
    modifier: Modifier?

) {

    if (modifier != null) {
        Text(
            text = text,
            color = color,
            fontSize = sp.sp,
            fontWeight = fontWeight,
            modifier = modifier,
        )
    }else{
        Text(
            text = text,
            color = color,
            fontSize = sp.sp,
            fontWeight = fontWeight
        )
    }
}

@Composable
fun GenericCard(
    modifier: Modifier,
    elevation: CardElevation,
    colors: CardColors,
    shape: Shape?,
    content: @Composable () -> Unit
) {
    if (shape != null) {
        Card(
            modifier = modifier,
            elevation = elevation,
            colors = colors,
            shape = shape
        ) {
            content()
        }
    }
}

@Composable
fun GenericDivider(thickness: Int, color: Color) {
    Divider(thickness = thickness.dp, color = color)
}

val questionControlRequirements = listOf(
    "Requiere permiso de alto riesgo:",
    "Requiere bloqueo y etiquetado:",
    "Requiere acordonamiento y aviso:",
    "Requiere permiso de chispa o flama:"
)

val questionSecurityEquipements = listOf(
    "Equipo basico de seguridad:",
    "Tengo los materiales adecuados",
    "Mascarilla para humos de soldadura:",
    "Mascarilla para polvos:"
)




