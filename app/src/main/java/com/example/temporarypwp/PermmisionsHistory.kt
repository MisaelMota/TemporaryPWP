package com.example.temporarypwp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericText

@Composable
fun PermissionHistory() {

    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color(0xFFAEF4A0))
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GenericText(
                text = "Historial",
                sp = 30,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = null
            )

            Box(modifier = Modifier.padding(start = 130.dp)) {
                GenericButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
                    height = 100,
                    width = 100,
                    text = null,
                    imagePainter = R.drawable.search_icon
                )
            }

        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 120.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Column() {
            GenericCard(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(360.dp)
                    .height(135.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                ),
                colors = CardDefaults.cardColors(
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    containerColor = MaterialTheme.colorScheme.background
                ),
                shape = RoundedCornerShape(size = 15.dp)
            ) {

                Column(
                    Modifier
                        .background(brush = gradient)
                        .height(150.dp)
                        .padding(start = 10.dp)
                        .fillMaxWidth()
                ) {

                    GenericText(
                        text = "ID PERMISO",
                        sp = 14,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.scrim,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    GenericText(
                        text = "Permiso de prueba a realizar",
                        sp = 12,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(top = 10.dp)
                    )
                    GenericText(
                        text = "Area",
                        sp = 12,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )

                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        GenericText(
                            text = "APROBADO",
                            sp = 12,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = null
                        )
                        GenericText(
                            text = "|20/05/2023",
                            sp = 12,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = null
                        )
                    }

                }
            }
        }


    }
}