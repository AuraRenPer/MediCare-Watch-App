package com.example.myfirstwearapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myfirstwearapp.MedicationViewModel

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: MedicationViewModel) {
    NavHost(navController = navController, startDestination = "main_screen") {

        composable("main_screen") {
            MainScreen(viewModel = viewModel, onMedicationTime = { medication ->
                navController.navigate("alert_screen")
            })
        }

        composable("alert_screen") {
            viewModel.medications.value.firstOrNull()?.let { it1 ->
                MedicationAlertScreen(
                    medication = it1,
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }

        composable("next_dose_screen") {
            NextDoseScreen(
                timeUntilNextDose = "En un tiempo...",
                navController = navController
            )
        }
    }
}
