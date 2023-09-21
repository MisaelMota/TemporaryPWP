package com.example.temporarypwp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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


    /* Box(
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 62.dp),
         contentAlignment = Alignment.TopCenter
     ) {
         GenericDivider(thickness = 1, color = MaterialTheme.colorScheme.secondary)
     }*/

    Box(
        modifier = Modifier
            //.fillMaxSize()
            .padding(top = 150.dp, bottom = 60.dp, start = 30.dp, end = 30.dp)
            .size(100.dp, 100.dp)
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


@Composable
fun TabScreen() {
    val tabItems = listOf("Tab 1", "Tab 2", "Tab 3")
    val selectedTabIndex = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp)
    ) {
        GenericText(
            text = "Detalle de permisos",
            sp = 20,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = null
        )
    }


    Column(modifier = Modifier.padding(top = 50.dp)) {
        TabRow(selectedTabIndex.value) {
            tabItems.forEachIndexed { index, text ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = { selectedTabIndex.value = index },
                    text = { Text(text) }
                )
            }
        }

    }


    when (selectedTabIndex.value) {
        0 -> {
            PermissionsDetail()
        }

        1 -> {
            RiskActivitiesMeasures()
        }

        2 -> {
            ControlRequirementsDetail()
        }
    }

}


@Composable
fun ControlRequirementsDetail() {
    val data = listOf(
        listOf("Requisito de control", "Respuesta"),
        listOf("Requiere permiso de alto riesgo", "Si"),
        listOf("Requiere bloqueo y etiquetado", "Si"),
        listOf("Requiere acordonamiento y aviso", "Si"),
        listOf("Requiere permiso de chispa o flama", "Si"),
    )


    LazyColumn(modifier =  Modifier.padding(top = 150.dp)) {
        itemsIndexed(data) { index, row ->
            val isHeaderRow = index == 0
            val backgroundColor = if (isHeaderRow) Color.White else Color.White
            val textColor = if (isHeaderRow) Color.Black else Color.Black

            Row(
                modifier = Modifier
                    .background(backgroundColor)
                    .padding(start = 50.dp),

            ) {
                row.forEach { cell ->
                    Text(
                        text = cell,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        color = textColor,
                        style = if (isHeaderRow) TextStyle(fontWeight = FontWeight.Bold) else TextStyle.Default
                    )
                }
            }
        }
    }

    LazyColumn (modifier =  Modifier.padding(top = 470.dp)){
        itemsIndexed(data) { index, row ->
            val isHeaderRow = index == 0
            val backgroundColor = if (isHeaderRow) Color.White else Color.White
            val textColor = if (isHeaderRow) Color.Black else Color.Black

            Row(
                modifier = Modifier
                    .background(backgroundColor)
                    .padding(start = 50.dp),

            ) {
                row.forEach { cell ->
                    Text(
                        text = cell,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        color = textColor,
                        style = if (isHeaderRow) TextStyle(fontWeight = FontWeight.Bold) else TextStyle.Default
                    )
                }
            }
        }
    }
}

@Composable
fun RiskActivitiesMeasuresDetail() {
    val data = listOf(
        listOf("Requisito de control", "Respuesta"),
        listOf("Requiere permiso de alto riesgo", "Si"),
        listOf("Requiere bloqueo y etiquetado", "Si"),
        listOf("Requiere acordonamiento y aviso", "Si"),
        listOf("Requiere permiso de chispa o flama", "Si"),
    )


    LazyColumn {
        itemsIndexed(data) { index, row ->
            val isHeaderRow = index == 0
            val backgroundColor = if (isHeaderRow) Color.White else Color.White
            val textColor = if (isHeaderRow) Color.Black else Color.Black

            Row(
                modifier = Modifier
                    .background(backgroundColor)
                    .padding(start = 50.dp),

            ) {
                row.forEach { cell ->
                    Text(
                        text = cell,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        color = textColor,
                        style = if (isHeaderRow) TextStyle(fontWeight = FontWeight.Bold) else TextStyle.Default
                    )
                }
            }
        }
    }
}