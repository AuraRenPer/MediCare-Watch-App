package com.example.myfirstwearapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.myfirstwearapp.ui.NavigationGraph

class MainActivity : ComponentActivity() {
    private val viewModel: MedicationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationGraph(navController = navController, viewModel = viewModel)
        }
    }
}
