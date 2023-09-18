package com.example.temporarypwp

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericDivider
import com.example.temporarypwp.Components.GenericText
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("MutableCollectionMutableState")
@Composable
fun ToDoList(repeatElement: Boolean, titleText: String, fieldText: String,addText: String) {
    //Variable que representa la lista de task (Lista mutable observable)
    //remember { mutableStateOf(mutableListOf<String>()) no es observable
    val tasks = remember  { mutableStateListOf<String>() }

    //variable que representa la lista de opciones
    var options = remember  { mutableListOf("Moises", "Misael", "Pablo", "Jefry") }

    //Variable que representa la opcion seleccionada
    var selectedOption by remember  { mutableStateOf<String?>(null) }

    //Guarda el estado del drop down, si esta abierto o cerrado
    var expanded by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val filteredOptions = options.filter { it.contains(selectedOption ?: "", ignoreCase = true) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 75.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericText(
            text = titleText,
            sp = 20,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
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
                label = { Text(text = fieldText) },
                readOnly = false,
                //trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .size(294.dp, 68.dp),
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
            .fillMaxWidth()
            .padding(top = 265.dp),
        contentAlignment = Alignment.TopCenter

    ) {
        GenericButton(
            imagePainter = null,
            onClick = {
                if (options.contains(selectedOption)) {
                    selectedOption?.let { tasks.add(it) }
                    if (!repeatElement) {
                        options.remove(selectedOption)
                    }
                    selectedOption = null
                } else {
                    Toast.makeText(context, "This element don't exists", Toast.LENGTH_LONG)
                        .show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            height = 60,
            width = 294,
            text = addText

        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 365.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericDivider(thickness = 1, color = MaterialTheme.colorScheme.secondary)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 400.dp, bottom = 100.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn {
            items(tasks) { task ->
                GenericCard(
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .border(
                            2.dp,
                            MaterialTheme.colorScheme.primary,
                            RoundedCornerShape(10.dp)
                        )
                    ,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    ),
                    colors = CardDefaults.cardColors(
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        containerColor = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(304.dp, 63.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 30.dp, end = 60.dp),
                            text = task
                        )

                        GenericButton(
                            onClick = {
                                tasks.remove(task)
                                if (task !in options) {
                                    options.add(task)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
                            height = 100,
                            width = 100,
                            text = null,
                            imagePainter = R.drawable.remove_logo
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








