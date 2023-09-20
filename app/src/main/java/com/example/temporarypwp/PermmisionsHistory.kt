package com.example.temporarypwp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericText

@Composable
fun PermissionHistory() {

    val IDPermiso = listOf("000000", "111111", "222222", "333333", "444444", "555555")
    val Descripcion = listOf(
        "Permiso de prueba",
        "Permiso de prueba",
        "Permiso de prueba",
        "Permiso de prueba",
        "Permiso de prueba",
        "Permiso de prueba"
    )
    val Area =
        listOf("Operaciones", "Envase", "Horno", "Mantenimiento", "Mantenimiento", "Mantenimiento")
    val Status = listOf("Aprobado", "Cancelado", "Revisado", "Cancelado", "Cancelado", "Pendiente")
    val Date = listOf("12/02/23", "12/02/23", "12/02/23", "12/02/23", "12/02/23", "12/02/23")

    val gradient = Brush.verticalGradient(
        colorStops = arrayOf(
            0.253f to Color(0x41F1F0F0),
            0.6f to MaterialTheme.colorScheme.surfaceTint
        )
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

        Column(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            IDPermiso.forEachIndexed { index, ID ->
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
                            text = ID,
                            sp = 15,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.scrim,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box() {

                                GenericText(
                                    text = Descripcion[index],
                                    sp = 13,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                )
                                GenericText(
                                    text = Area[index],
                                    sp = 13,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier
                                        .padding(top = 40.dp)
                                )
                            }

                            if (Status[index] == "Aprobado") {

                                Box(modifier = Modifier.padding(start = 150.dp, top = 32.dp)) {
                                    Icon(
                                        Icons.Filled.Done,
                                        contentDescription = "Check Icon",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }

                            } else if (Status[index] == "Cancelado") {

                                Box(modifier = Modifier.padding(start = 150.dp, top = 32.dp)) {
                                    Icon(
                                        Icons.Filled.Close,
                                        contentDescription = "Cancel Icon",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }

                            } else if (Status[index] == "Revisado") {

                                Box(modifier = Modifier.padding(start = 150.dp, top = 32.dp)) {
                                    Icon(
                                        painterResource(id = R.drawable.description_icon),
                                        contentDescription = "Search Icon",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }

                            } else {
                                Box(modifier = Modifier.padding(start = 150.dp, top = 32.dp)) {
                                    Icon(
                                       painterResource(id = R.drawable.schedule_icon),
                                        contentDescription = "Check Icon",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }

                            }
                        }

                        Row(modifier = Modifier.padding(top = 5.dp)) {
                            if (Status[index] == "Aprobado") {
                                GenericText(
                                    text = Status[index],
                                    sp = 13,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = null
                                )
                            } else if (Status[index] == "Cancelado") {
                                GenericText(
                                    text = Status[index],
                                    sp = 13,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.secondary,
                                    modifier = null
                                )
                            } else {
                                GenericText(
                                    text = Status[index],
                                    sp = 13,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.surfaceVariant,
                                    modifier = null
                                )
                            }

                            GenericText(
                                text = "|" + Date[index],
                                sp = 13,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = null
                            )
                        }


                    }


                    Row(
                        modifier = Modifier
                            .padding(top=60.dp, start = 30.dp,end=30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom

                    ) {
                        GenericButton(
                            onClick = { /*TODO*/ },
                            colors =ButtonDefaults.buttonColors(containerColor = Color.Unspecified) ,
                            height =100 ,
                            width = 100,
                            text = null,
                            imagePainter = R.drawable.bell_navbar
                        )
                        GenericButton(
                            onClick = { /*TODO*/ },
                            colors =ButtonDefaults.buttonColors(containerColor = Color.Unspecified) ,
                            height =100,
                            width = 100,
                            text = null,
                            imagePainter = R.drawable.home_navbar
                        )
                    }


                }
            }
        }


    }
}