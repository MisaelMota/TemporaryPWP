package com.example.temporarypwp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericText

@Composable
fun Login() {

    var loginNFC by remember { mutableStateOf(true) }
    var conditionalText by remember { mutableStateOf("") }

    conditionalText = if (loginNFC) {
        LoginNFC()
        "Pulsa aqui si no tienes NFC"
    } else {
        LoginTypical()
        "Pulsa aqui si tienes NFC"
    }



    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.padding(bottom = 15.dp)
    ) {
        Text(
            text = conditionalText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.clickable { loginNFC = !loginNFC },
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }

}


@Composable
fun LoginNFC() {

    Box(
        modifier = Modifier.padding(top = 250.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericText(
            text = "USE NFC",
            sp = 24,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold,
            modifier = null
        )
    }

    Box(
        //Modifier.padding(top = 90.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(

            painter = painterResource(id = R.drawable.id_card2),
            contentDescription = "Logo Login",
            modifier = Modifier.padding()
        )
    }

    Box(
        modifier = Modifier.padding(end = 20.dp, start = 20.dp, top = 250.dp),
        contentAlignment = Alignment.Center
    ) {
        GenericText(
            text = "Tab your personal identification Tag the NFC to the device.",
            sp = 16,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Normal,
            modifier = null
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTypical() {
    val userEmail = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisibility by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(top = 220.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericCard(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .width(310.dp)
                .height(418.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            ),
            colors = CardDefaults.cardColors(
                contentColor = MaterialTheme.colorScheme.onBackground,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = RoundedCornerShape(size = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                GenericText(
                    text = "Login",
                    sp = 24,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = null
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = userEmail.value,
                    onValueChange = { userEmail.value = it },
                    modifier = Modifier
                        .width(221.dp)
                        .height(55.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                        cursorColor = MaterialTheme.colorScheme.onBackground
                    ),
                    placeholder = { Text(text = "Usuario") }
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    modifier = Modifier
                        .width(221.dp)
                        .height(55.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                        cursorColor = MaterialTheme.colorScheme.onBackground
                    ),
                    visualTransformation = if (passwordVisibility) {
                        VisualTransformation.None

                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            val icon: Painter = if (passwordVisibility) {
                                painterResource(id = R.drawable.visibility_icon)
                            } else {
                                painterResource(id = R.drawable.visibility_off)
                            }
                            Icon(painter = icon, contentDescription = "Visibilidad de contraseña")
                        }
                    },
                    placeholder = { Text(text = "Contraseña") }

                )


            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Box(

                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                GenericButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    height = 40,
                    width = 158,
                    text = "Login",
                    imagePainter = null
                )

            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {

                Image(
                    painter = painterResource(id = R.drawable.cemex_logo_login),
                    contentDescription = "Cemex Logo"
                )
            }

        }
    }
}