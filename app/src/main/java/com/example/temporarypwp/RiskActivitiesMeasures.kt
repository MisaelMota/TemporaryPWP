package com.example.temporarypwp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericText




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiskActivitiesMeasures(){
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember  { mutableStateOf<String?>(null) }
    var options = remember  { mutableListOf("Moises", "Misael", "Pablo", "Jefry") }
    val filteredOptions = options.filter { it.contains(selectedOption ?: "", ignoreCase = true) }



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
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },

            ) {
            OutlinedTextField(
                value = selectedOption ?: "",
                onValueChange = { selectedOption = it },
                label = { Text(text = "Introduzca actividad a realizar") },
                readOnly = false,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .size(325.dp, 68.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colorScheme.onBackground,
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    cursorColor = MaterialTheme.colorScheme.onBackground
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { !expanded }
            ) {
                filteredOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            selectedOption = option
                            expanded = false

                        }

                    )
                }
            }


        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 160.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },

            ) {
            OutlinedTextField(
                value = selectedOption ?: "",
                onValueChange = { selectedOption = it },
                label = { Text(text = "Introduzca actividad a realizar") },
                readOnly = false,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .size(325.dp, 68.dp),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colorScheme.onBackground,
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    cursorColor = MaterialTheme.colorScheme.onBackground
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { !expanded }
            ) {
                filteredOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            selectedOption = option
                            expanded = false

                        }

                    )
                }
            }


        }

    }














}