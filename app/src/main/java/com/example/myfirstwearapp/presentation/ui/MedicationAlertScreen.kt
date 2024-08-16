package com.example.myfirstwearapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myfirstwearapp.MedicationViewModel
import com.example.myfirstwearapp.data.Medication

@Composable
fun MedicationAlertScreen(
    medication: Medication,
    navController: NavHostController,
    viewModel: MedicationViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)  // Fondo blanco
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¡Es hora de tomar ${medication.nombre}!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    viewModel.onConfirmMedication(navController.context, medication)
                    navController.navigate("next_dose_screen") {
                        popUpTo("main_screen") { inclusive = true }
                    }
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Green)  // Botón verde
            ) {
                Text("Check", style = MaterialTheme.typography.bodyMedium, color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Red)  // Botón rojo
            ) {
                Text("Cancel", style = MaterialTheme.typography.bodyMedium, color = Color.White)
            }
        }
    }
}
