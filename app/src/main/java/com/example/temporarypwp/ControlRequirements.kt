package com.example.temporarypwp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericDivider
import com.example.temporarypwp.Components.GenericText
import com.example.temporarypwp.Components.questionControlRequirements
import com.example.temporarypwp.Components.questionSecurityEquipements

@Composable
fun ControlRequirements() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp)
    ) {
        GenericText(
            text = "Requisitos de Control",
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

    val options = listOf("Sí", "No", "N/A")
    var selectedOptions by remember { mutableStateOf(questionControlRequirements.associateWith { null as String? }) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp, bottom = 50.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column() {
            questionControlRequirements.forEach { question ->
                val selectedOption = selectedOptions[question]
                GenericCard(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .border(
                            2.dp,
                            Color.Unspecified
                        ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    ),
                    colors = CardDefaults.cardColors(
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        containerColor = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
                {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = question
                    )

                    Row(
                        modifier = Modifier
                            .height(48.dp)
                            .width(350.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        options.forEach { option ->
                            RadioButton(
                                selected = selectedOption == option,
                                onClick = { selectedOptions = selectedOptions.toMutableMap().apply { this[question] = option } },
                                enabled = true,
                                colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.secondary)
                            )
                            Text(option)
                        }
                    }

                }
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 440.dp, start = 10.dp)
    ) {
        GenericText(
            text = "Equipo de Seguridad",
            sp = 20,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = null
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 470.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericDivider(thickness = 1, color = MaterialTheme.colorScheme.secondary)
    }

    val optionsSecurityEquipements = listOf("Sí", "No", "N/A")
    var selectedOptionsSecurityEquipements by remember { mutableStateOf(questionSecurityEquipements.associateWith { null as String? }) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 480.dp, bottom = 100.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            questionSecurityEquipements.forEach { question ->
                val selectedOption = selectedOptionsSecurityEquipements[question]
                GenericCard(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .border(
                            2.dp,
                            Color.Unspecified,
                            RoundedCornerShape(30.dp)
                        ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    ),
                    colors = CardDefaults.cardColors(
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        containerColor = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
                {
                    Text(
                        // modifier= Modifier.padding(start = 50.dp),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = question
                    )

                    Row(
                        modifier = Modifier
                            .height(48.dp)
                            .width(350.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        optionsSecurityEquipements.forEach { option ->
                            RadioButton(
                                selected = selectedOption == option,
                                onClick = {
                                    selectedOptionsSecurityEquipements = selectedOptionsSecurityEquipements.toMutableMap()
                                        .apply { this[question] = option }
                                },
                                enabled = true,
                                colors = RadioButtonDefaults.colors(MaterialTheme.colorScheme.secondary)
                            )
                            Text(option)
                        }
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