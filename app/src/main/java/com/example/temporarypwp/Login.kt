package com.example.temporarypwp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.temporarypwp.Components.GenericCard
import com.example.temporarypwp.Components.GenericText

@Composable
fun Login(){
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

    Box(Modifier.padding(top = 90.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(painter = painterResource(id = R.drawable.id_card2), contentDescription = "Logo Login")
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
            shape = RoundedCornerShape(size = 45.dp)
        ){

        }
    }
}