package com.example.temporarypwp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.DropDownsRiskActivitiesMeasures
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericDivider
import com.example.temporarypwp.Components.GenericText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiskActivitiesMeasures() {

    //Variables para expandir los dropdown
    val expanded = remember { mutableStateOf(false) }
    var expanded2 = remember { mutableStateOf(false) }
    var expanded3 = remember { mutableStateOf(false) }
    var expanded4 = remember { mutableStateOf(false) }
    var expanded5 = remember { mutableStateOf(false) }
    var expanded6 = remember { mutableStateOf(false) }
    var expanded7 = remember { mutableStateOf(false) }
    var expanded8 = remember { mutableStateOf(false) }
    var expanded9 = remember { mutableStateOf(false) }
    var expanded10 = remember { mutableStateOf(false) }

    //Variables para la opcion seleccionada
    val selectedOption = remember { mutableStateOf<String?>(null) }
    var selectedOption2 = remember { mutableStateOf<String?>(null) }
    var selectedOption3 = remember { mutableStateOf<String?>(null) }
    var selectedOption4 = remember { mutableStateOf<String?>(null) }
    var selectedOption5 = remember { mutableStateOf<String?>(null) }
    var selectedOption6 = remember { mutableStateOf<String?>(null) }
    var selectedOption7 = remember { mutableStateOf<String?>(null) }
    var selectedOption8 = remember { mutableStateOf<String?>(null) }
    var selectedOption9 = remember { mutableStateOf<String?>(null) }
    var selectedOption10 = remember { mutableStateOf<String?>(null) }


    var options = remember { mutableListOf("Moises", "Misael", "Pablo", "Jefry") }
    val filteredOptions =
        options.filter { it.contains(selectedOption.value ?: "", ignoreCase = true) }
    val filteredOptions2 =
        options.filter { it.contains(selectedOption2.value ?: "", ignoreCase = true) }
    val filteredOptions3 =
        options.filter { it.contains(selectedOption3.value ?: "", ignoreCase = true) }
    val filteredOptions4 =
        options.filter { it.contains(selectedOption4.value ?: "", ignoreCase = true) }
    val filteredOptions5 =
        options.filter { it.contains(selectedOption5.value ?: "", ignoreCase = true) }
    val filteredOptions6 =
        options.filter { it.contains(selectedOption6.value ?: "", ignoreCase = true) }
    val filteredOptions7 =
        options.filter { it.contains(selectedOption7.value ?: "", ignoreCase = true) }
    val filteredOptions8 =
        options.filter { it.contains(selectedOption8.value ?: "", ignoreCase = true) }
    val filteredOptions9 =
        options.filter { it.contains(selectedOption9.value ?: "", ignoreCase = true) }
    val filteredOptions10 =
        options.filter { it.contains(selectedOption9.value ?: "", ignoreCase = true) }



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 75.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericText(
            text = "Actividades de riesgo y medidas",
            sp = 20,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold,
            modifier = null
        )

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 160.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        DropDownsRiskActivitiesMeasures(
            expanded = expanded,
            selectedOption = selectedOption,
            filteredOptions = filteredOptions,
            width = 340,
            height = 60,
            title = "Introduca la actividad a realizar"
        )

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 240.dp, start = 40.dp, bottom = 20.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column(Modifier.weight(1f)) {
                DropDownsRiskActivitiesMeasures(
                    expanded = expanded2,
                    selectedOption = selectedOption2,
                    filteredOptions = filteredOptions2,
                    width = 150,
                    height = 52,
                    title = "Riesgo"
                )
                DropDownsRiskActivitiesMeasures(
                    expanded = expanded3,
                    selectedOption = selectedOption3,
                    filteredOptions = filteredOptions3,
                    width = 150,
                    height = 52,
                    title = "Riesgo"
                )
                DropDownsRiskActivitiesMeasures(
                    expanded = expanded4,
                    selectedOption = selectedOption4,
                    filteredOptions = filteredOptions4,
                    width = 150,
                    height = 52,
                    title = "Riesgo"
                )
            }

            Column(Modifier.weight(1f)) {
                DropDownsRiskActivitiesMeasures(
                    expanded = expanded5,
                    selectedOption = selectedOption5,
                    filteredOptions = filteredOptions5,
                    width = 150,
                    height = 52,
                    title = "Nivel"
                )
                DropDownsRiskActivitiesMeasures(
                    expanded = expanded6,
                    selectedOption = selectedOption6,
                    filteredOptions = filteredOptions6,
                    width = 150,
                    height = 52,
                    title = "Nivel"
                )
                DropDownsRiskActivitiesMeasures(
                    expanded = expanded7,
                    selectedOption = selectedOption7,
                    filteredOptions = filteredOptions7,
                    width = 150,
                    height = 52,
                    title = "Nivel"
                )
            }
        }

        Column(modifier =Modifier.padding(top=160.dp)) {
            DropDownsRiskActivitiesMeasures(
                expanded = expanded8,
                selectedOption = selectedOption8,
                filteredOptions = filteredOptions8,
                width = 340,
                height = 52,
                title = "Medidas preventivas"
            )
            DropDownsRiskActivitiesMeasures(
                expanded = expanded9,
                selectedOption = selectedOption9,
                filteredOptions = filteredOptions9,
                width = 340,
                height = 52,
                title = "Medidas preventivas"
            )
            DropDownsRiskActivitiesMeasures(
                expanded = expanded10,
                selectedOption = selectedOption10,
                filteredOptions = filteredOptions10,
                width = 340,
                height = 52,
                title = "Medidas preventivas"
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 580.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericDivider(thickness = 1, color = MaterialTheme.colorScheme.secondary)
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 150.dp),
        contentAlignment = Alignment.BottomCenter

    ) {
        GenericButton(
            imagePainter = null,
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            height = 60,
            width = 294,
            text = "Agregar actividad"

        )
    }

    Row(
        modifier = Modifier
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom

    ) {
        GenericButton(
            onClick = { /*TODO*/ },
            colors =ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary) ,
            height =38 ,
            width = 115,
            text = "Cancelar",
            imagePainter = null
        )
        GenericButton(
            onClick = { /*TODO*/ },
            colors =ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary) ,
            height =38,
            width = 115,
            text = "Siguiente",
            imagePainter = null
        )
    }



}