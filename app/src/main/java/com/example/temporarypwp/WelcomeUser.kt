package com.example.temporarypwp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
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
import com.example.temporarypwp.Components.GenericText

@Composable
fun WelcomeUser() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 75.dp, start = 40.dp),
        contentAlignment = Alignment.TopStart
    ) {
        GenericText(
            text = "Bienvenido, Fulano",
            sp = 24,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold,
            modifier = null
        )

    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 130.dp, start = 40.dp),
        contentAlignment = Alignment.TopStart
    ) {
        GenericText(
            text = "Permisos mas recientes:",
            sp = 24,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Normal,
            modifier = null
        )

    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 220.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        GenericCard(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .width(305.dp)
                .height(188.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            ),
            colors = CardDefaults.cardColors(
                contentColor = MaterialTheme.colorScheme.onBackground,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = RoundedCornerShape(size = 45.dp)
        ){

        }
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
            text = "Solicitar permisos"

        )
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