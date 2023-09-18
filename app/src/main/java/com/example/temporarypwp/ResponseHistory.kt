package com.example.temporarypwp

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericDivider
import com.example.temporarypwp.Components.GenericText

@Composable
fun ResponseHistory() {
    val CardText = listOf("Detalles de permisos", "Respuestas que aplican", "Todas las respuestas")
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp)
    ) {
        GenericText(
            text = "Historial de Respuestas",
            sp = 20,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = null
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericDivider(thickness = 1, color = MaterialTheme.colorScheme.secondary)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 120.dp, bottom = 50.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column() {
            CardText.forEach { response ->
                GenericCard(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    ),
                    colors = CardDefaults.cardColors(
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        containerColor = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(size = 45.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .size(324.dp, 90.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = response)
                        GenericButton(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
                            height = 150,
                            width = 150,
                            text = null,
                            imagePainter = R.drawable.arrow_down_navigate2
                        )
                    }

                }
            }
        }
    }

    Row(
        modifier = Modifier
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom

    ) {
        GenericButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary) ,
            height =38 ,
            width = 115,
            text = "Cancelar",
            imagePainter = null
        )
        GenericButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary) ,
            height =38,
            width = 115,
            text = "Siguiente",
            imagePainter = null
        )
    }


}

