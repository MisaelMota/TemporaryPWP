package com.example.temporarypwp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericButton
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {

    val userEmail = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
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
        Modifier.padding(top = 90.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.id_card2),
            contentDescription = "Logo Login"
        )
    }



    Box(
        modifier = Modifier
            .padding(top = 220.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericCard(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .width(267.dp)
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
                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                GenericText(
                    text = "Login",
                    sp = 24,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = null
                )
            }


            Column(modifier = Modifier.padding(top = 50.dp, start = 20.dp)) {
                GenericText(
                    text = "Usuario:",
                    sp = 16,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = null
                )

                OutlinedTextField(
                    value = userEmail.value,
                    onValueChange = { userEmail.value = it },
                    modifier = Modifier
                        .width(221.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.secondary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                        cursorColor = MaterialTheme.colorScheme.onBackground
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

                GenericText(
                    text = "Contraseña:",
                    sp = 16,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = null
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    modifier = Modifier
                        .width(221.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.secondary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                        cursorColor = MaterialTheme.colorScheme.onBackground
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )




            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Box(
                modifier = Modifier.padding(start = 50.dp,),
                contentAlignment = Alignment.BottomCenter) {
                GenericButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary) ,
                    height =40,
                    width = 158,
                    text = "Login",
                    imagePainter = null
                )

            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Box(modifier = Modifier.padding(start = 90.dp,),contentAlignment = Alignment.BottomCenter) {

                Image(painter = painterResource(id = R.drawable.cemex_logo_login), contentDescription ="Cemex Logo" )
            }

        }
    }
}