package com.example.myfirstwearapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstwearapp.data.Medication
import com.example.myfirstwearapp.MedicationViewModel

@Composable
fun MainScreen(viewModel: MedicationViewModel, onMedicationTime: (Medication) -> Unit) {
    val medications = viewModel.medications.value

    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(medications) { medication ->
                MedicationItem(medication, onMedicationTime)
            }
        }
    }
}

@Composable
fun MedicationItem(medication: Medication, onMedicationTime: (Medication) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMedicationTime(medication) }
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)  // Usando CardDefaults.cardElevation
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Text(
                text = medication.nombre,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Dosis: ${medication.dosis}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Presentación: ${medication.presentación}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Próxima toma: ${String.format("%02d", medication.proxima_toma.hora)}:${String.format("%02d", medication.proxima_toma.minuto)}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}
