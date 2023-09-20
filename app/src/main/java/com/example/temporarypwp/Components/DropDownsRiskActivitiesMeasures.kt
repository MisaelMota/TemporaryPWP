package com.example.temporarypwp.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownsRiskActivitiesMeasures(
    expanded: MutableState<Boolean>,
    selectedOption: MutableState<String?>,
    filteredOptions: List<String>,
    width: Int,
    height: Int,
    title: String,
    paddingStart: Int
) {
    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = { expanded.value = !expanded.value },
    ) {
        OutlinedTextField(
            value = selectedOption.value ?: "",
            onValueChange = { selectedOption.value = it },
            label = {
                Text(
                    text = title,
                    Modifier.padding(start = paddingStart.dp),
                    textAlign = TextAlign.Center
                )
            },
            readOnly = false,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value) },
            modifier = Modifier
                .menuAnchor()
                .size(width.dp, height.dp),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.onBackground,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = MaterialTheme.colorScheme.onBackground
            ),
            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center
            )


        )
        ExposedDropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            filteredOptions.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            textAlign = TextAlign.Center
                        )
                    },
                    onClick = {
                        selectedOption.value = option
                        expanded.value = false
                    }
                )
            }
        }
    }
}
