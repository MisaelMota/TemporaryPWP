package com.example.temporarypwp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericDivider
import com.example.temporarypwp.Components.GenericText

@Composable
fun PermissionsDetail() {

    val CardText =
        listOf("Trabajo realizado:", "Estado de permiso:", "Autorizado por:", "Fecha y Hora:")
    val CardTextResponse =
        listOf("Pruebe de pruebas", "Aprobado", "Fulanito De Tal", "12/02/23 : 5:13PM")

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
                text = "Detalle de permisos",
                sp = 20,
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
                    imagePainter = R.drawable.arrow_down_navigate2
                )
            }

        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 62.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericDivider(thickness = 1, color = MaterialTheme.colorScheme.secondary)
    }

    Box(
        modifier = Modifier
            //.fillMaxWidth()
            .padding(top = 120.dp, bottom = 30.dp, start = 30.dp, end = 30.dp)
            .border(
                2.dp,
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(25.dp)
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.padding(top = 20.dp)) {
            CardText.forEachIndexed { index, cardText ->
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
                    shape = RoundedCornerShape(size = 26.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .size(257.dp, 63.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        GenericText(
                            text = cardText,
                            sp = 14,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = null
                        )

                        if (CardTextResponse[index] == "Aprobado") {

                            GenericText(
                                text = CardTextResponse[index],
                                sp = 14,
                                fontWeight = FontWeight.Normal,
                                color = Color.Green,
                                modifier = null
                            )

                        } else if (CardTextResponse[index] == "Cancelado") {

                            GenericText(
                                text = CardTextResponse[index],
                                sp = 14,
                                fontWeight = FontWeight.Normal,
                                color = Color.Red,
                                modifier = null
                            )

                        } else if (CardTextResponse[index] == "Revisado") {

                            GenericText(
                                text = CardTextResponse[index],
                                sp = 14,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                modifier = null
                            )

                        } else if (CardTextResponse[index] == "Pendiente") {

                            GenericText(
                                text = CardTextResponse[index],
                                sp = 14,
                                fontWeight = FontWeight.Normal,
                                color = Color.Blue,
                                modifier = null
                            )

                        } else {
                            GenericText(
                                text = CardTextResponse[index],
                                sp = 14,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = null
                            )
                        }


                    }
                }
            }
        }
    }


}